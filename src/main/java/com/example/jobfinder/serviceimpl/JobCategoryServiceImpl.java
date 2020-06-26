package com.example.jobfinder.serviceimpl;

import com.example.jobfinder.entity.post.JobCategory;
import com.example.jobfinder.repository.JobCategoryRepository;
import com.example.jobfinder.service.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobCategoryServiceImpl implements JobCategoryService {
    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    @Override
    public List<JobCategory> findAll() {
        Sort sort = Sort.by("name");
        return jobCategoryRepository.findAll(sort);
    }
}
