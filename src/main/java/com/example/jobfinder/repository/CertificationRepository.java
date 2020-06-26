package com.example.jobfinder.repository;

import com.example.jobfinder.entity.profile.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificationRepository extends JpaRepository<Certification,Integer> {
    List<Certification> findByProfileId(Integer id);
}
