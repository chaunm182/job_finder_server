package com.example.jobfinder.rest;

import com.example.jobfinder.entity.person.Subscriber;
import com.example.jobfinder.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class SubscriberRestController {

    @Autowired
    private SubscriberService subscriberService;

    @GetMapping("/api/subscribers/{userId}")
    public List<Subscriber> findByUserId(@PathVariable("userId")Integer id){
        return subscriberService.findByUserId(id);
    }

    @GetMapping("/api/subscribers/{userId},{jobCategoryId}")
    public Subscriber findByUserIdAndJobCategoryId(@PathVariable("userId") Integer userId,
                                                   @PathVariable("jobCategoryId")Integer jobCategoryId){
        return subscriberService.findByUserIdAndJobCategoryId(userId,jobCategoryId);
    }

    @PostMapping("/api/subscribers")
    public Subscriber addSubscriber(@RequestBody Subscriber subscriber){
        subscriber.setCreatedAt(new Date());
        return subscriberService.save(subscriber);
    }

    @DeleteMapping("/api/subscribers/{id}")
    public Boolean delete(@PathVariable("id") Integer id){
        boolean result = true;
        try{
            subscriberService.deleteById(id);
        }catch (Exception ex){
            result = false;
        }
        return result;
    }
}
