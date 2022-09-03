package com.day14.demorabbitmq.consumer;

import com.day14.demorabbitmq.model.Accounts;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class AccountQueueConsumer {

    @RabbitListener(queues = {"${queue.name}"})
    public void process(@Payload Accounts accounts) {
        System.out.printf(
                "<%s> <(%s)> terdaftar sebagai user baru",
                accounts.getUsername(),
                accounts.getEmail()
        );
    }

    @RabbitListener(queues = {"${queue.name}"})
    public void processFailed(@Payload Accounts accounts) {
        System.out.printf(
                "<%s> username dan email <(%s)> sudah terdaftar",
                accounts.getUsername(),
                accounts.getEmail()
        );
    }
}
