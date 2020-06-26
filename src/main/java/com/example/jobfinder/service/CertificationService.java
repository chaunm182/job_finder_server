package com.example.jobfinder.service;

import com.example.jobfinder.entity.profile.Certification;

import java.util.List;

public interface CertificationService {
    List<Certification> findByProfileId(Integer profileId);
    Certification findById(Integer id);
    Certification save(Certification certification);
    void deleteById(Integer id);

}
