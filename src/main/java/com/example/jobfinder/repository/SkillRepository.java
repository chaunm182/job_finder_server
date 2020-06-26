package com.example.jobfinder.repository;

import com.example.jobfinder.entity.profile.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill,Integer> {
    List<Skill> findByProfileId(Integer profileId);
}
