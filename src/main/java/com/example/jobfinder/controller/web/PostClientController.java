package com.example.jobfinder.controller.web;

import com.example.jobfinder.entity.person.User;
import com.example.jobfinder.entity.post.Post;
import com.example.jobfinder.entity.post.RecruitmentDetail;
import com.example.jobfinder.service.PostService;
import com.example.jobfinder.service.RecruitmentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class PostClientController {

    @Autowired
    private PostService postService;

    @Autowired
    private RecruitmentDetailService recruitmentDetailService;

    @GetMapping("/post")
    public String showPostDetail(@RequestParam("id") Integer id, Model model, HttpSession session){
        Post post = postService.findById(id);
        if(post==null){
            return "404";
        }

        User signedInUser = (User) session.getAttribute("account");
        RecruitmentDetail recruitmentDetail = recruitmentDetailService.findByPostIdAndUserId(id,signedInUser.getId());

        model.addAttribute("post",post);
        model.addAttribute("recruitmentDetail",recruitmentDetail);
        return "web/post-detail";
    }
}
