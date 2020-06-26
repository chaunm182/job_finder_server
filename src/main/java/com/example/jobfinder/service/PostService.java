package com.example.jobfinder.service;

import com.example.jobfinder.entity.post.Post;

import java.util.List;
import java.util.Map;

public interface PostService {
    List<Post> findAll();
    Post save(Post post);
    List<Post> findPostsByCompanyId(Integer id);
    void delete(Integer id);
    Post findById(Integer id);
    List<String> findAllAddress();
    List<Post> search(String jobName, Integer jobCategoryId, String address);
    List<Post> findByJobNameLike(String jobName);
    List<Post> findByProps(Map<String,String> props);
}
