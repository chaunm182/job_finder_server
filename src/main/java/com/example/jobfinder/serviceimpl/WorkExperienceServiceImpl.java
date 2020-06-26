package com.example.jobfinder.serviceimpl;

import com.example.jobfinder.entity.profile.WorkExperience;
import com.example.jobfinder.repository.WorkExperienceRepository;
import com.example.jobfinder.service.WorkExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkExperienceServiceImpl implements WorkExperienceService {

    @Autowired
    private WorkExperienceRepository workExperienceRepository;

    @Override
    public List<WorkExperience> findByProfileId(Integer profileId) {
        return workExperienceRepository.findByProfileId(profileId);
    }

    @Override
    public WorkExperience findById(Integer id) {
        Optional<WorkExperience> workExperienceOptional = workExperienceRepository.findById(id);
        return workExperienceOptional.orElse(null);
    }

    @Override
    public WorkExperience save(WorkExperience workExperience) {
        return workExperienceRepository.save(workExperience);
    }

    @Override
    public void deleteById(Integer id) {
        workExperienceRepository.deleteById(id);
    }
}
