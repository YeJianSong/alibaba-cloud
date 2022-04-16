package com.alibaba.cloud.message.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @program: alibaba.cloud.message
 * @description: 测试消息消费者
 * @author: JianSong Ye
 * @create: 2022-04-10 16:11
 **/
@Slf4j
@Component
//监听的队列名称 TestDirectQueue
//@RabbitListener(queues = "TestDirectQueue")
public class DirectConsumerReceiver {

    @RabbitHandler
    public void process(Map testMessage) {
        log.info("DirectConsumerReceiver消费者收到消息  :{} " ,testMessage.toString());
    }

}
