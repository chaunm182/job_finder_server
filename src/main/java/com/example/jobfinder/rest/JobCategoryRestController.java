package com.example.jobfinder.rest;

import com.example.jobfinder.entity.post.JobCategory;
import com.example.jobfinder.service.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class JobCategoryRestController {

    @Autowired
    private JobCategoryService jobCategoryService;

    @GetMapping("/jobCategories")
    public List<JobCategory> findAll(){
        return jobCategoryService.findAll();
    }
}
