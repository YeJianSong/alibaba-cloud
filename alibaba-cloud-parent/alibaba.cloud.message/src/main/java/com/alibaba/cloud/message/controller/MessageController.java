package com.alibaba.cloud.message.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @GetMapping("/sed")
    public void sendMessage(HttpServletRequest request, @PathVariable("message") String message) {
        rabbitTemplate.convertAndSend("direct", message);
    }


}
