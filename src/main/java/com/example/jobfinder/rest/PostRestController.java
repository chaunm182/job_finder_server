package com.example.jobfinder.rest;

import com.example.jobfinder.entity.post.Post;
import com.example.jobfinder.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostRestController {

    @Autowired
    private PostService postService;


    @GetMapping("/posts")
    public List<Post> findByJobNameLikeAndJobCategoryIdAndAdress(@RequestParam Map<String,String> properties){
        return postService.findByProps(properties);
    }

    @GetMapping("/posts/all")
    public List<Post> findAll(){
        return postService.findAll();
    }

    @GetMapping("/posts/all/address")
    public List<String> findAllAddress(){
        return postService.findAllAddress();
    }


}
