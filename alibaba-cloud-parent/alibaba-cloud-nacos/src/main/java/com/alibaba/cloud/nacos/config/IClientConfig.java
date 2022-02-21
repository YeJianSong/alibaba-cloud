package com.alibaba.cloud.nacos.config;

import com.netflix.client.config.DefaultClientConfigImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IClientConfig {

    @Bean
    public DefaultClientConfigImpl iClientConfig() {
        return new DefaultClientConfigImpl();
    }
}
