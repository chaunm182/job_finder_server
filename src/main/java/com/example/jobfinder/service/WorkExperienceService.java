package com.example.jobfinder.service;

import com.example.jobfinder.entity.profile.WorkExperience;

import java.util.List;

public interface WorkExperienceService {
    List<WorkExperience> findByProfileId(Integer profileId);
    WorkExperience findById(Integer id);
    WorkExperience save(WorkExperience workExperience);
    void deleteById(Integer id);
}
