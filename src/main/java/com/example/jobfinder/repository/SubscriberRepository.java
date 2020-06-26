package com.example.jobfinder.repository;

import com.example.jobfinder.entity.person.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriberRepository extends JpaRepository<Subscriber,Integer> {
    List<Subscriber> findByUserId(Integer id);
    Subscriber findByUserIdAndJobCategoryId(Integer userId,Integer jobCategoryId);
    List<Subscriber> findByJobCategoryId(Integer jobCategoryId);
}
