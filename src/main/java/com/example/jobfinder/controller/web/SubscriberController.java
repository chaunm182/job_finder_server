package com.example.jobfinder.controller.web;


import com.example.jobfinder.entity.person.Subscriber;
import com.example.jobfinder.entity.person.User;
import com.example.jobfinder.entity.post.JobCategory;
import com.example.jobfinder.service.JobCategoryService;
import com.example.jobfinder.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SubscriberController {

    @Autowired
    private JobCategoryService jobCategoryService;

    @Autowired
    private SubscriberService subscriberService;

    @GetMapping("/subscriber")
    public String showSubscriberPage(Model model, HttpSession session){
        User currentUser = (User) session.getAttribute("account");
        List<JobCategory> jobCategories = jobCategoryService.findAll();
        List<Subscriber> subscribers = subscriberService.findByUserId(currentUser.getId());

        model.addAttribute("jobCategories",jobCategories);
        model.addAttribute("subscribers",subscribers);
        return "web/subscriber";
    }
}
