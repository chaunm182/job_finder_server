package com.example.jobfinder.serviceimpl;

import com.example.jobfinder.entity.profile.Education;
import com.example.jobfinder.repository.EducationRepository;
import com.example.jobfinder.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationServiceImpl implements EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Override
    public List<Education> findByProfileId(Integer profileId) {
        return educationRepository.findByProfileId(profileId);
    }

    @Override
    public Education save(Education education) {
        return educationRepository.save(education);
    }

    @Override
    public void deleteById(Integer id) {
        educationRepository.deleteById(id);
    }

    @Override
    public Education findById(Integer id) {
        Optional<Education> educationOptional = educationRepository.findById(id);
        return educationOptional.orElse(null);
    }
}
