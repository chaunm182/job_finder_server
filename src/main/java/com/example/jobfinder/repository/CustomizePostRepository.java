package com.example.jobfinder.repository;

import com.example.jobfinder.entity.post.Post;

import java.util.List;
import java.util.Map;

public interface CustomizePostRepository {
    List<Post> findByProperties(Map<String,String> properties);
}
