package com.alibaba.cloud.message.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @program: alibaba.cloud.message
 * @description: 扇形交换机B
 * @author: JianSong Ye
 * @create: 2022-04-10 16:43
 **/
@Slf4j
@Component
@RabbitListener(queues = "fanout.B")
public class FanoutConsumerReceiverB {
    @RabbitHandler
    public void process(Map testMessage) {
        log.info("FanoutConsumerReceiverB消费者收到消息  :{} ", testMessage.toString());
    }
}
