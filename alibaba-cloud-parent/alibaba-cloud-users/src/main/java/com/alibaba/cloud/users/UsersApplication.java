package com.alibaba.cloud.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //开启Openfeign调用支持
public class UsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class);
    }
}
