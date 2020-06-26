package com.example.jobfinder.service;

import com.example.jobfinder.entity.profile.Skill;

import java.util.List;

public interface SkillService {
    List<Skill> findByProfileId(Integer profileId);
    Skill findById(Integer id);
    Skill save(Skill skill);
    void deleteById(Integer id);
}
