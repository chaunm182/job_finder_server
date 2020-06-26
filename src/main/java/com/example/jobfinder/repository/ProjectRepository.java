package com.example.jobfinder.repository;

import com.example.jobfinder.entity.profile.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    List<Project> findByProfileId(Integer profileId);

}
