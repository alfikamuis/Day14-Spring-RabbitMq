package com.day14.demorabbitmq.service;

import com.day14.demorabbitmq.model.Accounts;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PubliserService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(Accounts payload) {
        String sendMsg =
                payload.getUsername()
                + " dan "
                + payload.getEmail()
                + "terdaftar sebagai user baru";
        rabbitTemplate.convertAndSend(this.queue.getName(),sendMsg);
    }
}

