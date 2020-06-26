package com.example.jobfinder.serviceimpl;

import com.example.jobfinder.entity.profile.Skill;
import com.example.jobfinder.repository.SkillRepository;
import com.example.jobfinder.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<Skill> findByProfileId(Integer profileId) {
        return skillRepository.findByProfileId(profileId);
    }

    @Override
    public Skill findById(Integer id) {
        Optional<Skill> skillOptional = skillRepository.findById(id);
        return skillOptional.orElse(null);
    }

    @Override
    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public void deleteById(Integer id) {
        skillRepository.deleteById(id);
    }
}
