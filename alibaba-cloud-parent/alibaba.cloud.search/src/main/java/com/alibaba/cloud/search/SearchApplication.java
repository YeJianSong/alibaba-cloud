package com.alibaba.cloud.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: alibaba-cloud-parent
 * @description: elasticsearch 搜索微服务
 * @author: JianSong Ye
 * @create: 2022-05-15 15:52
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class SearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringApplication.class);
    }
}
