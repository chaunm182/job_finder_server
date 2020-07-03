package com.example.jobfinder.rest;


import com.example.jobfinder.entity.account.Account;
import com.example.jobfinder.entity.account.Role;
import com.example.jobfinder.entity.person.User;
import com.example.jobfinder.entity.profile.Profile;
import com.example.jobfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @PostMapping("/users/register")
    public User registerNewUser(@RequestBody User user){
        Role role = new Role();
        role.setId(3); //nomal user
        Account account = user.getAccount();
        account.setRole(role);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setActive(true);
        user.setProfile(new Profile());
        return userService.save(user);
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable("id") Integer id){
        return userService.findById(id);
    }

    @GetMapping("users/mail/{email}")
    public User findByEmail(@PathVariable("email")String email){
        return userService.findByEmail(email);
    }

    @GetMapping("/users/accounts/{id}")
    public User findByAccountId(@PathVariable("id") Integer accountId){
        return userService.findUserByAccountId(accountId);
    }
}
