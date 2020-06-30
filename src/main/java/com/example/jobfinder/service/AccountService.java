package com.example.jobfinder.service;

import com.example.jobfinder.entity.account.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    Account findAccountByUsername(String username);
    Account save(Account account);
}
