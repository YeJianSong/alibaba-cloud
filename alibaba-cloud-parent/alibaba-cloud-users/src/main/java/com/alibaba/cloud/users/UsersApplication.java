package com.alibaba.cloud.users;

import com.alibaba.cloud.users.config.RibbonRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
//开启Openfeign调用支持
@EnableFeignClients
//可配置多个  RibbonRuleConfig不能被@SpringBootApplication的@ComponentScan扫描到，所以把它放到上一层，否则就是全局配置的效果
@RibbonClients(value = {@RibbonClient(name = "USERS",configuration = RibbonRuleConfig.class)})
public class UsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class);
    }

    /**
     * 使用RestTemplate远程调用，必须new 一个RestTemplate并放入spring容器当中,否则启动时报错
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(30 * 1000);
        httpRequestFactory.setConnectTimeout(30 * 3000);
        httpRequestFactory.setReadTimeout(30 * 3000);
        return new RestTemplate(httpRequestFactory);

    }
}
