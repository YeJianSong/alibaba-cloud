package com.alibaba.cloud.message.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MQConfig {

    //队列名称
    final static String QUEUE_NAME = "direct";

    //交换器名称
    final static String EXCHANGE_NAME = "mydirect";

    @Bean
    public Queue queue() {
        // 声明队列 参数一：队列名称；参数二：是否持久化
        return new Queue(MQConfig.QUEUE_NAME, false);
    }

    /**
     * 配置默认的交换机，以下部分都可以不配置，不设置使用默认交换器（AMQP default）
     * @return
     */
    @Bean
    DirectExchange directExchange() {
        // 参数一：交换器名称；参数二：是否持久化；参数三：是否自动删除消息
        return new DirectExchange(MQConfig.EXCHANGE_NAME, false, false);
    }

    /**
     * 绑定“direct”队列到上面配置的“mydirect”路由器
     * @param directQueue
     * @param directExchange
     * @return
     */
    @Bean
    Binding bindingExchangeDirectQueue(Queue directQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue).to(directExchange).with(MQConfig.QUEUE_NAME);
    }


}
