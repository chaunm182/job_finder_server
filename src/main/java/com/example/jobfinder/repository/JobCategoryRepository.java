package com.example.jobfinder.repository;

import com.example.jobfinder.entity.post.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobCategoryRepository extends JpaRepository<JobCategory,Integer> {
}
