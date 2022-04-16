package com.alibaba.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: alibaba.cloud.gateway
 * @description: 跨域配置
 * @author: JianSong Ye
 * @create: 2022-04-10 15:28
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class);
    }

}
