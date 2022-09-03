package com.day14.demorabbitmq.service;

import com.day14.demorabbitmq.model.Accounts;
import com.day14.demorabbitmq.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsServiceImpl implements AccountService{

    @Autowired
    private AccountsRepository accountsRepository;

    @Override
    public Accounts register(Accounts accounts) {
       return accountsRepository.save(accounts);
    }
}
