package com.example.qlbh.controller;

import com.example.qlbh.model.Account;
import com.example.qlbh.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    // den trang dang ky
    @GetMapping("/register")
    public String FromThemKH(Model model) {
        model.addAttribute("account", new Account());
        return "/homePages/register";
    }

    // tao moi account
    @PostMapping("/createAccount")
    public String createAccount(Account account) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(account.getPassword());
        account.setPassword(encodedPassword);
        // gan role "ROLE_MEMBER" cho account
        accountService.createAccount(account);

        System.out.printf(account.getEmail());
        accountService.createAccountRole(account.getId(),2);

        return "redirect:/login";
    }
}
