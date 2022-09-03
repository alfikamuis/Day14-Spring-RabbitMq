package com.day14.demorabbitmq.controller;

import com.day14.demorabbitmq.model.Accounts;
import com.day14.demorabbitmq.service.AccountService;
import com.day14.demorabbitmq.service.PubliserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {

    @Autowired
    private AccountService accountService; //for db

    @Autowired
    PubliserService publiserService; //for publiser

    @PostMapping("/registrasi")
    public String registerUserByRabbit (@RequestBody Accounts accounts){
        accountService.register(accounts); //post to db
        publiserService.send(accounts); // publish

        //String theMessages = accounts.getUsername() +" dan "+ accounts.getEmail() + " terdaftar sebagai user baru";
        return "Account created, and message send to Queue";
    }
}
