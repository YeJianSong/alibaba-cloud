package com.alibaba.cloud.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: alibaba.cloud.message
 * @description: 消息中心服务
 * @author: JianSong Ye
 * @create: 2022-04-10 15:28
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class MessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class);
    }
}
