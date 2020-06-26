package com.example.jobfinder.rest;


import com.example.jobfinder.entity.person.User;
import com.example.jobfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private UserService userService;

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        return userService.save(user);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable("id") Integer id){
        return userService.findById(id);
    }

    @GetMapping("/users/accounts/{id}")
    public User findByAccountId(@PathVariable("id") Integer accountId){
        return userService.findUserByAccountId(accountId);
    }
}
