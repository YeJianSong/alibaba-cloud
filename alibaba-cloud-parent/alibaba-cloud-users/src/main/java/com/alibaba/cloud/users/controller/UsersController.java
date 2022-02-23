package com.alibaba.cloud.users.controller;

import com.alibaba.cloud.users.api.ProductClient;
import com.alibaba.cloud.users.config.BusinessThreadPoolManager;
import com.alibaba.cloud.users.service.AsyncService;
import com.alibaba.cloud.users.service.UsersService;
import feign.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Queue;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private UsersService usersService;

    @Autowired
    private AsyncService asyncService;

    @Autowired
    private BusinessThreadPoolManager threadPoolManager;

    @GetMapping("/invoke")
    public String invokeProduct() {
        String result = productClient.product(21);
        return "调用用户服务成功.....使用openFeignClient远程调用商品服务结果：{}" + result;
    }

    @GetMapping("/ticket/{name}")
    public String ticket(HttpServletRequest request, @PathVariable("name") String name) {
        String randomName = name + ":" + UUID.randomUUID().toString();
        usersService.ticket(randomName);
        return randomName + "抢票成功！！！";
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
        return "Test ThreadPoolExecutor start";
    }


    @GetMapping("/async/thread-pool")
    public String asyncThreadPool() {
        //调用service层的任务
        asyncService.executeAsync();
        return "Test AsyncThreadPool Succeed";
    }


}
