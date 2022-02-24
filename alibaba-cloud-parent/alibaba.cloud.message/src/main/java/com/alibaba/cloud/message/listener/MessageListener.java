package com.alibaba.cloud.message.listener;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "direct")
public class MessageListener {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * 监听消费消息
     */
    @RabbitHandler
    public void process(String message) {
        System.out.println("监听到消息：{}"+ message);
    }
}
