package com.example.qlbh.service.impl;

import com.example.qlbh.model.Account;
import com.example.qlbh.repository.AccountRepository;
import com.example.qlbh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

//    @Override
//    public void createAccount(String email, String password, String full_name, String number_phone, String address) {
//        accountRepository.createAccount(email,password,full_name,number_phone,address);
//    }

    @Override
    public void createAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void createAccountRole(int accountId, int roleId) {
        accountRepository.createAccountRole(accountId,roleId);
    }
}
