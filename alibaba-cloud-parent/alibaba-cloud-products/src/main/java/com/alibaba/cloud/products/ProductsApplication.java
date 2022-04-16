package com.alibaba.cloud.products;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: alibaba.cloud.products
 * @description: TODO
 * @author: JianSong Ye
 * @create: 2022-04-10 15:28
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ProductsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductsApplication.class);
    }


}
