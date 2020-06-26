package com.example.jobfinder.rest;

import com.example.jobfinder.entity.account.Account;
import com.example.jobfinder.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/accounts/{username},{password}")
    public Account findAccountByUsernameAndPassword(@PathVariable("username") String username,
                                                    @PathVariable("password") String password){
        Account account = accountService.findAccountByUsername(username);
        if (account==null || !passwordEncoder.matches(password,account.getPassword())) return null;
        return account;
    }
}
