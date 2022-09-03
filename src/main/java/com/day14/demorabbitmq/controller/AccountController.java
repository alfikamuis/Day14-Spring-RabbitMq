package com.day14.demorabbitmq.controller;

import com.day14.demorabbitmq.Stopwatch;
import com.day14.demorabbitmq.consumer.AccountQueueConsumer;
import com.day14.demorabbitmq.model.Accounts;
import com.day14.demorabbitmq.service.AccountService;
import com.day14.demorabbitmq.service.AccountsServiceImpl;
import com.day14.demorabbitmq.service.PubliserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountQueueConsumer accountQueueConsumer;

    @Autowired
    private AccountService accountService;

    @Autowired
    PubliserService publiserService;

    @PostMapping("/registrasi")
    public ResponseEntity<Accounts> registerUser (@RequestBody Accounts accounts){
        Stopwatch timer = new Stopwatch();
        accountService.register(accounts);

        double timeTaken =  timer.elapsed();
        System.out.printf("waktu yang dibutuhkan %.2f",timeTaken);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(accounts);
    }

    @PostMapping("/registrasi-rabbit")
    public ResponseEntity<Accounts> registerUserByRabbit (@RequestBody Accounts accounts){
        Stopwatch timer = new Stopwatch();
        accountService.register(accounts);
        publiserService.send(accounts);

        double timeTaken =  timer.elapsed();
        System.out.printf("waktu yang dibutuhkan %.2f",timeTaken);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(accounts);
    }
}
