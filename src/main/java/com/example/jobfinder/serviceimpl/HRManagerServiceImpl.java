package com.example.jobfinder.serviceimpl;

import com.example.jobfinder.entity.person.HRManager;
import com.example.jobfinder.repository.HRRepository;
import com.example.jobfinder.service.HRManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HRManagerServiceImpl implements HRManagerService {

    @Autowired
    private HRRepository hrRepository;
    @Override
    public HRManager findByAccountUsername(String username) {
        Optional<HRManager> hrManagerOptional = hrRepository.findHRManagerByAccount_Username(username);
        if(!hrManagerOptional.isPresent()) return null;
        return hrManagerOptional.get();
    }
}
