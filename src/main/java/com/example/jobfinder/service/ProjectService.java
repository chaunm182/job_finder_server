package com.example.jobfinder.service;

import com.example.jobfinder.entity.profile.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findByProfileId(Integer profileId);
    Project save(Project project);
    Project findById(Integer id);
    void deleteById(Integer id);
}
