package com.example.jobfinder.serviceimpl;

import com.example.jobfinder.entity.profile.Certification;
import com.example.jobfinder.repository.CertificationRepository;
import com.example.jobfinder.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationServiceImpl implements CertificationService {

    @Autowired
    private CertificationRepository certificationRepository;

    @Override
    public List<Certification> findByProfileId(Integer profileId) {
        return certificationRepository.findByProfileId(profileId);
    }

    @Override
    public Certification findById(Integer id) {
        Optional<Certification> certificationOptional = certificationRepository.findById(id);
        return certificationOptional.orElse(null);
    }

    @Override
    public Certification save(Certification certification) {
        return certificationRepository.save(certification);
    }

    @Override
    public void deleteById(Integer id) {
        certificationRepository.deleteById(id);
    }
}
