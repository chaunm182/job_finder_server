package com.example.jobfinder.controller;

import com.example.jobfinder.entity.person.User;
import com.example.jobfinder.entity.post.Post;
import com.example.jobfinder.entity.post.RecruitmentDetail;
import com.example.jobfinder.entity.profile.Education;
import com.example.jobfinder.service.EducationService;
import com.example.jobfinder.service.PostService;
import com.example.jobfinder.service.RecruitmentDetailService;
import com.example.jobfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RecruitmentDetailController {

    @Autowired
    private RecruitmentDetailService recruitmentDetailService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private EducationService educationService;

    @GetMapping("/admin/candidates")
    public String showListCandidatesPage(@RequestParam(value = "postId", required = true)Integer postId,
                                         Model model){
        List<RecruitmentDetail> recruitmentDetailList =  recruitmentDetailService.findByPostId(postId);
        Post post = postService.findById(postId);
        model.addAttribute("candidates",recruitmentDetailList);
        model.addAttribute("post",post);
        return "admin/post/list-candidates";
    }

    @GetMapping("/admin/candidates/profile")
    public String showCandidateProfile(@RequestParam(value = "id", required = true)Integer userId,Model model){
        User user = userService.findById(userId);
        List<Education> educations = educationService.findByProfileId(user.getProfile().getId());

        model.addAttribute("user",user);
        model.addAttribute("educations",educations);
        return "admin/candidate-profile";
    }

    @GetMapping("/admin/candidates/update-form")
    public String showUpdateCandidateStatusForm(@RequestParam("postId")Integer postId,
                                                @RequestParam("userId") Integer userId, Model model){
        RecruitmentDetail recruitmentDetail = recruitmentDetailService.findByPostIdAndUserId(postId,userId);
        model.addAttribute("recruimentDetail",recruitmentDetail);
        return "admin/post/update-candidate-status";
    }
}
