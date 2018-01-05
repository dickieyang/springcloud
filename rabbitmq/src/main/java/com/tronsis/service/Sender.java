/*
package com.tronsis.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);

    }

    public void sendAndReceive(String hello){
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        String res = this.rabbitTemplate.convertSendAndReceive("hello", context).toString();
        System.out.println("Receive msg : " + res);
    }
}*/
