package com.example.jobfinder.service;

import com.example.jobfinder.entity.profile.Prize;

import java.util.List;

public interface PrizeService {
    List<Prize> findByProfileId(Integer profileId);
    Prize findById(Integer id);
    Prize save(Prize prize);
    void deleteById(Integer id);
}
