package com.alibaba.cloud.products.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: alibaba.cloud.products
 * @description: TODO
 * @author: JianSong Ye
 * @create: 2022-04-10 15:28
 **/
@RestController
@RefreshScope
@RequestMapping("/api/products")
public class ProductsController {

    @Value("${server.port}")
    private int port;

    @Value("${constomer.username}")
    private String username;

    @GetMapping("/product/{id}")
    public String products(@PathVariable("id") Integer id) {
        return "调用商品服务(" + username + ")返回：" + id + ",当前提供服务的端口为：" + port;
    }


}
