package com.day14.demorabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude={org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration.class})
//publiser
public class DemoRabbitmqApplication {

	public static void main(String[] args) {

		System.out.println("Start >>");
		SpringApplication.run(DemoRabbitmqApplication.class, args);
	}

}
