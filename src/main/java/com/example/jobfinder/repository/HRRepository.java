package com.example.jobfinder.repository;

import com.example.jobfinder.entity.person.HRManager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HRRepository extends JpaRepository<HRManager,Integer> {
    Optional<HRManager> findHRManagerByAccount_Username(String username);
}
