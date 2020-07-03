package com.example.jobfinder.serviceimpl;

import com.example.jobfinder.entity.person.User;
import com.example.jobfinder.repository.UserRepository;
import com.example.jobfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByAccountUsername(String username) {
        Optional<User> userOptional = userRepository.findUserByAccount_Username(username);
        return userOptional.orElse(null);
    }

    @Override
    public User findById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);

    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findUserByAccountId(Integer accountId) {
        Optional<User> userOptional =  userRepository.findUserByAccountId(accountId);
        return userOptional.orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> userOptional =  userRepository.findUserByAccountEmail(email);
        return userOptional.orElse(null);
    }
}
