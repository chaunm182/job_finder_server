package com.example.jobfinder.repository;

import com.example.jobfinder.entity.profile.Prize;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrizeRepository extends JpaRepository<Prize,Integer> {
    List<Prize> findByProfileId(Integer profileId);
}
