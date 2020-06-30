package com.example.jobfinder.serviceimpl;

import com.example.jobfinder.authentication.AuthenticationAccount;
import com.example.jobfinder.entity.account.Account;
import com.example.jobfinder.repository.AccountRepository;
import com.example.jobfinder.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Account> accountOptional = accountRepository.findAccountByUsername(s);
        if(!accountOptional.isPresent()) throw new UsernameNotFoundException("Username not found: "+s);
        Account account = accountOptional.get();
        AuthenticationAccount authenticationAccount = new AuthenticationAccount();
        authenticationAccount.setUsername(account.getUsername());
        authenticationAccount.setPassword(account.getPassword());
        authenticationAccount.setActive(account.getActive());
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(account.getRole().getName()));
        authenticationAccount.setAuthorities(grantedAuthorities);
        return authenticationAccount;
    }

    @Override
    public Account findAccountByUsername(String username) {
        Optional<Account> accountOptional = accountRepository.findAccountByUsername(username);
        return accountOptional.orElse(null);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }
}
