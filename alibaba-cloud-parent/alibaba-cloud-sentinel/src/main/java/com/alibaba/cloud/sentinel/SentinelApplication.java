package com.alibaba.cloud.sentinel;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.alibaba.cloud.sentinel.exception.SentinelUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication.class);
    }


    /**
     * @SentinelRestTemplate: 对所有的接口统一限流熔断处理
     * @return
     */
    @SentinelRestTemplate(blockHandlerClass = SentinelUtils.class, blockHandler = "handleBlock",
            fallbackClass = SentinelUtils.class, fallback = "handleFallback")
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

