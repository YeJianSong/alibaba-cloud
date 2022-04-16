package com.alibaba.cloud.nacos.config;

import com.netflix.client.config.DefaultClientConfigImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: alibaba.cloud.nacos
 * @description: 处理nacos服务注册配置中心启动报错
 * @author: JianSong Ye
 * @create: 2022-04-10 15:28
 **/
@Configuration
public class IClientConfig {

    @Bean
    public DefaultClientConfigImpl iClientConfig() {
        return new DefaultClientConfigImpl();
    }
}
