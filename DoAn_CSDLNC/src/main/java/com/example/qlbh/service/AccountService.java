package com.example.qlbh.service;

import com.example.qlbh.model.Account;

public interface AccountService {

//    void createAccount(String email,String password , String full_name,String number_phone , String address)
    void  createAccount(Account account);
    void createAccountRole(int accountId, int roleId);
}
