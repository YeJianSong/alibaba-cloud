package com.alibaba.cloud.users.controller;

import com.alibaba.cloud.users.api.ProductClient;
import com.alibaba.cloud.users.service.UsersService;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private UsersService usersService;

    @GetMapping("/invoke")
    public String invokeProduct() {
        String result = productClient.product(21);
        return "调用用户服务成功.....使用openFeignClient调用商品服务结果：{}" + result;
    }

    @GetMapping("/ticket")
    public String ticket() {
        String name =  UUID.randomUUID().toString();
        usersService.ticket(name);
        return name + "抢票成功！！！";
    }



}
