package com.example.jobfinder.controller;

import com.example.jobfinder.entity.post.JobCategory;
import com.example.jobfinder.entity.post.Post;
import com.example.jobfinder.service.JobCategoryService;
import com.example.jobfinder.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @Autowired
    private JobCategoryService jobCategoryService;

    @GetMapping("/")
    public String showHomePage(Model model){
        List<Post> posts = postService.findAll();
        model.addAttribute("posts",posts);
        return "web/home";
    }

    @GetMapping("/search")
    public String showSearchPage(Model model){
        List<JobCategory> jobCategories = jobCategoryService.findAll();
        model.addAttribute("jobCategories",jobCategories);

        List<String> addressList = postService.findAllAddress();
        model.addAttribute("addressList",addressList);

        return "web/search";
    }

    @GetMapping("/access-denied")
    public String showAccessDeniedPage(){
        return "access-denied";
    }
}
