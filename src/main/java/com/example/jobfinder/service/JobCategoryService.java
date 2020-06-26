package com.example.jobfinder.service;

import com.example.jobfinder.entity.post.JobCategory;

import java.util.List;

public interface JobCategoryService {
    List<JobCategory> findAll();
}
