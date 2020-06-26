package com.example.jobfinder.service;

import com.example.jobfinder.entity.person.User;



public interface UserService {
    User save(User user);
    User findByAccountUsername(String username);
    User findById(Integer id);
    void deleteById(Integer id);
    User findUserByAccountId(Integer accountId);
}
