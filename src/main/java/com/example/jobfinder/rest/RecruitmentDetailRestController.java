package com.example.jobfinder.rest;

import com.example.jobfinder.entity.post.RecruitmentDetail;
import com.example.jobfinder.service.RecruitmentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class RecruitmentDetailRestController {

    @Autowired
    private RecruitmentDetailService recruitmentDetailService;

    @GetMapping("/recruitmentDetails/{postId},{userId}")
    public RecruitmentDetail findByPostIdAndUserId(@PathVariable("postId")Integer postId,
                                                   @PathVariable("userId")Integer userId){
        return recruitmentDetailService.findByPostIdAndUserId(postId,userId);
    }

    @PostMapping("/recruitmentDetails")
    public RecruitmentDetail applyJob(@RequestBody RecruitmentDetail recruitmentDetail){
        recruitmentDetail.setApplyAt(new Date(System.currentTimeMillis()));
        recruitmentDetail.setStatus("Đang chờ duyệt");
        recruitmentDetailService.save(recruitmentDetail);
        return recruitmentDetail;
    }

    @PutMapping("/recruitmentDetails")
    public RecruitmentDetail updateRecruitmentDetail(@RequestBody RecruitmentDetail recruitmentDetail){
        return recruitmentDetailService.save(recruitmentDetail);
    }
}
