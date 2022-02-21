package com.alibaba.cloud.products.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/product/{id}")
    public String products(@PathVariable("id") Integer id){
        return "调用商品服务返回："+id+",当前提供服务的端口为："+port;
    }

    
}
