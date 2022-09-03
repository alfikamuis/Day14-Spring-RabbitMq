package com.day14.demorabbitmq.service;

import com.day14.demorabbitmq.model.Accounts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PubliserService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    private static Logger logger = (Logger) LogManager.getLogger(PubliserService.class.toString());

    public void send(Accounts accounts){
        rabbitTemplate.convertAndSend(queue.getName(), accounts);
        String theMessages ="username: "+ accounts.getUsername() +", email: "+ accounts.getEmail() + " terdaftar sebagai user baru\n";
        logger.info("Sending messages - "+theMessages);
    }
}

