package com.alibaba.cloud.users.controller;

import com.alibaba.cloud.users.api.ProductClient;
import com.alibaba.cloud.users.config.BusinessThreadPoolManager;
import com.alibaba.cloud.users.service.AsyncService;
import com.alibaba.cloud.users.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Queue;
import java.util.UUID;

/**
 * @program: alibaba.cloud.products
 * @description: TODO
 * @author: JianSong Ye
 * @create: 2022-04-10 15:28
 **/
@Slf4j
@RestController
@RefreshScope
@RequestMapping("/users")
public class UsersController {

    @Value("${server.port}")
    private int port;

    @Value("${constomer.username}")
    private String username;


    /**
     * 自动注入RestTemplate
     */
    private final RestTemplate restTemplate;

    @Autowired
    public UsersController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    private ProductClient productClient;

    @Autowired
    private UsersService usersService;

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private BusinessThreadPoolManager threadPoolManager;


    /**
     * 测试微服务之间的远程调用（openFeignClient）
     *
     * @return
     */
    @GetMapping("/invoke/{id}")
    public String invokeProduct(HttpServletRequest request, @PathVariable("id") Integer id) {
        String result = productClient.product(id);
        return "调用用户服务" + "(" + username + ")" + "成功,当前提供服务的端口为：" + port + ".....使用openFeignClient远程调用products服务结果：" + result;
    }


    @GetMapping("/ticket/{name}")
    public String ticket(HttpServletRequest request, @PathVariable("name") String name) {
        String randomName = name + ":" + UUID.randomUUID().toString();
        usersService.ticket(randomName);
        return randomName + "抢票成功！！！";
    }


    @GetMapping("/rest/{id}")
    public String rest(HttpServletRequest request, @PathVariable("id") Integer id) {
        ResponseEntity<String> result = this.restTemplate.exchange(String.format("http://localhost:8805/products/product/%s", id),
                HttpMethod.GET, null, String.class);
        return "使用restTemplate远程调用商品服务成功..........获取到返回结果" + result.getBody();
    }

    /**
     * 测试模拟下单请求 入口
     *
     * @param id
     * @return
     */
    @GetMapping("/start/{id}")
    public String start(@PathVariable("id") Long id) {
        //模拟的随机数
        String orderNo = System.currentTimeMillis() + UUID.randomUUID().toString();
        threadPoolManager.addOrders(orderNo);
        return "Test ThreadPoolExecutor start";
    }

    /**
     * 停止服务
     *
     * @param id
     * @return
     */
    @GetMapping("/end/{id}")
    public String end(@PathVariable Long id) {
        threadPoolManager.shutdown();
        Queue q = threadPoolManager.getMsgQueue();
        log.info("关闭了线程服务，还有未处理的信息条数：{}", q.size());
        return "Test ThreadPoolExecutor end";
    }


    @GetMapping("/async/thread-pool")
    public String asyncThreadPool() {
        //调用service层的任务
        asyncService.executeAsync();
        return "Test AsyncThreadPool Succeed";
    }


}
