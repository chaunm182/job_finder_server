package com.example.jobfinder.serviceimpl;

import com.example.jobfinder.entity.person.Subscriber;
import com.example.jobfinder.repository.SubscriberRepository;
import com.example.jobfinder.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private SubscriberRepository subscriberRepository;


    @Override
    public List<Subscriber> findByUserId(Integer id) {
        return subscriberRepository.findByUserId(id);
    }

    @Override
    public Subscriber save(Subscriber subscriber) {
        return subscriberRepository.save(subscriber);
    }

    @Override
    public Subscriber findByUserIdAndJobCategoryId(Integer userId, Integer jobCategoryId) {
        return subscriberRepository.findByUserIdAndJobCategoryId(userId,jobCategoryId);
    }

    @Override
    public void deleteById(Integer id) {
        subscriberRepository.deleteById(id);
    }

    @Override
    public List<Subscriber> findByJobCategoryId(Integer jobCategoryId) {
        return subscriberRepository.findByJobCategoryId(jobCategoryId);
    }
}
