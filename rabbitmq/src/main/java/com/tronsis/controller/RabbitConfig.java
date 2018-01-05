package com.tronsis.controller;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    
    //声明队列
    @Bean
    public Queue queue1() {
        return new Queue("hello.queue1", true); // true表示持久化该队列
    }
    
    @Bean
    public Queue queue2() {
        return new Queue("hello.queue2", true);
    }
    
    //声明交互器
    /*@Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }*/
    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    //绑定
    @Bean//精确匹配
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(directExchange()).with("key.1");
    }
    
    @Bean//匹配所有key.开头的key
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(directExchange()).with("key.q2");
    }
    
}
