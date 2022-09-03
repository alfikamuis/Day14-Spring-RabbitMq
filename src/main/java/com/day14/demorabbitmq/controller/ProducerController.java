package com.day14.demorabbitmq.controller;

import com.day14.demorabbitmq.Stopwatch;
import com.day14.demorabbitmq.consumer.AccountQueueConsumer;
import com.day14.demorabbitmq.model.Accounts;
import com.day14.demorabbitmq.service.AccountService;
import com.day14.demorabbitmq.service.PubliserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private AccountService accountService;

    PubliserService publiserService;
    public ProducerController (PubliserService publiserService){
        this.publiserService = publiserService;
    }

    @Value("${app.message}")
    private String message;

    @PostMapping("/registrasi-rabbit")
    public String registerUserByRabbit (@RequestBody Accounts accounts){
        accountService.register(accounts); //post to db
        publiserService.send(accounts); // publish

        //messages
        String theMessages = accounts.getUsername() +" dan "+ accounts.getEmail() + " terdaftar sebagai user baru\n";
        return theMessages + message;
    }
}
