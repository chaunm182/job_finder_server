package com.example.jobfinder.repository;

import com.example.jobfinder.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Integer> {
    Optional<Account> findAccountByUsername(String username);
}
