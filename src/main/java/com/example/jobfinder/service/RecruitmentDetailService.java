package com.example.jobfinder.service;

import com.example.jobfinder.entity.post.RecruitmentDetail;

import java.util.List;

public interface RecruitmentDetailService {
    List<RecruitmentDetail> findByPostId(Integer postId);
    RecruitmentDetail save(RecruitmentDetail recruitmentDetail);
    RecruitmentDetail findByPostIdAndUserId(Integer postId, Integer userId);
}
