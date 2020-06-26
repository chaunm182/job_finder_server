package com.example.jobfinder.aspect;

import com.example.jobfinder.entity.person.Subscriber;
import com.example.jobfinder.entity.post.Post;
import com.example.jobfinder.mail.SubscribeMail;
import com.example.jobfinder.service.MailService;
import com.example.jobfinder.service.PostService;
import com.example.jobfinder.service.SubscriberService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class MailAspect {

    @Autowired
    private PostService postService;

    @Autowired
    private SubscriberService subscriberService;

    @Autowired
    private MailService mailService;

    @AfterReturning(pointcut = "execution(* com.example.jobfinder.controller.PostController.addPost(..))")
    public void sendMail(JoinPoint joinPoint){
        Object[] args =  joinPoint.getArgs();
        Post post = (Post) args[0];
        List<Subscriber> subscribers = subscriberService.findByJobCategoryId(post.getJobCategory().getId());
        for(Subscriber subscriber: subscribers){
            SubscribeMail subscribeMail = new SubscribeMail();
            subscribeMail.setUser(subscriber.getUser());
            subscribeMail.setPost(post);
            subscribeMail.setSendTo(subscriber.getUser().getAccount().getEmail());
            subscribeMail.setSubject("Có một công việc mới được đăng tuyển");
            mailService.sendMail(subscribeMail);
        }

    }
}
