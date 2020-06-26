package com.example.jobfinder.repository;

import com.example.jobfinder.entity.profile.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience,Integer> {
    List<WorkExperience> findByProfileId(Integer profileId);
}
