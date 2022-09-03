package com.day14.demorabbitmq.consumer;

import com.day14.demorabbitmq.model.Accounts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;



@Component
@RabbitListener(queues = "rabbitmq.queue", id ="listener")
public class RabbitMqConsumer {

    private static Logger logger = LogManager.getLogger(RabbitMqConsumer.class.toString());

    @RabbitHandler
    public void receiver(Accounts accounts){
        logger.info("Account listener - "+ accounts.toString());
    }

}
