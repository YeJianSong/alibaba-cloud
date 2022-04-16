package com.alibaba.cloud.nacos.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: alibaba.cloud.nacos
 * @description: TODO
 * @author: JianSong Ye
 * @create: 2022-04-10 15:28
 **/
@RestController
@RefreshScope
@RequestMapping("/nacos")
public class NacosController {

    @Value("${server.port}")
    private int port;

    @Value("${constomer.username}")
    private String username;


    @GetMapping("/get-username")
    public String testConfig() {
        return "demo ok！！！" + username + ",当前提供服务的端口为：" + port;
    }
}
