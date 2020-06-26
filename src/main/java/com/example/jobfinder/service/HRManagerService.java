package com.example.jobfinder.service;

import com.example.jobfinder.entity.person.HRManager;

public interface HRManagerService {
    HRManager findByAccountUsername(String username);
}
