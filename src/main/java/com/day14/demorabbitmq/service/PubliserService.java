package com.day14.demorabbitmq.service;

import com.day14.demorabbitmq.model.Accounts;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PubliserService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public PubliserService(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;
    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;
    public void send(Accounts accounts){
        rabbitTemplate.convertAndSend(exchange,routingkey, accounts);
    }
}

