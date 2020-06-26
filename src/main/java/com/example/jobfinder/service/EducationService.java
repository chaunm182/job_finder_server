package com.example.jobfinder.service;

import com.example.jobfinder.entity.profile.Education;

import java.util.List;

public interface EducationService {
    List<Education> findByProfileId(Integer profileId);
    Education save(Education education);
    void deleteById(Integer id);
    Education findById(Integer id);
}
