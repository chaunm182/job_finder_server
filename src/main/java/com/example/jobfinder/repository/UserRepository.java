package com.example.jobfinder.repository;

import com.example.jobfinder.entity.person.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findUserByAccount_Username(String username);
    Optional<User> findUserByAccountId(Integer accountId);
}
