package com.example.jobfinder.service;

import com.example.jobfinder.entity.person.Subscriber;

import java.util.List;

public interface SubscriberService {
    List<Subscriber> findByUserId(Integer id);
    Subscriber save(Subscriber subscriber);
    Subscriber findByUserIdAndJobCategoryId(Integer userId,Integer jobCategoryId);
    void deleteById(Integer id);
    List<Subscriber> findByJobCategoryId(Integer jobCategoryId);
}
