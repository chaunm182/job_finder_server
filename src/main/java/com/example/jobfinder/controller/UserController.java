package com.example.jobfinder.controller;

import com.example.jobfinder.entity.account.Account;
import com.example.jobfinder.entity.account.Role;
import com.example.jobfinder.entity.person.User;
import com.example.jobfinder.entity.profile.Profile;
import com.example.jobfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@Controller
public class UserController {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void saveUser(@ModelAttribute("user")User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Role role = new Role();
        role.setId(3); //nomal user
        Account account = user.getAccount();
        account.setRole(role);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setActive(true);
        user.setProfile(new Profile());
        try{
            userService.save(user);
            response.sendRedirect("/login?register_success");
        }catch (Exception ex){
            logger.warning(ex.getMessage());
            request.setAttribute("error","");
        }

    }
}
