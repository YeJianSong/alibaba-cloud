package com.alibaba.cloud.nacos.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@RequestMapping("/nacos")
public class NacosController {


    @Value("${constomer.username}")
    private String username;

    @GetMapping("/get-username")
    public String testConfig(){
        return "demo ok！！！"+username;
    }
}
