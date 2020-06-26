package com.example.jobfinder.repository;

import com.example.jobfinder.entity.profile.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education,Integer> {
    List<Education> findByProfileId(Integer profileId);
}
