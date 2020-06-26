package com.example.jobfinder.serviceimpl;

import com.example.jobfinder.entity.post.RecruitmentDetail;
import com.example.jobfinder.repository.RecruitmentDetailRepository;
import com.example.jobfinder.service.RecruitmentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruitmentDetailServiceImpl implements RecruitmentDetailService {

    @Autowired
    private RecruitmentDetailRepository recruitmentDetailRepository;

    @Override
    public List<RecruitmentDetail> findByPostId(Integer postId) {
        return recruitmentDetailRepository.findRecruitmentDetailsByPostId(postId);
    }

    @Override
    public RecruitmentDetail save(RecruitmentDetail recruitmentDetail) {
        return recruitmentDetailRepository.save(recruitmentDetail);
    }

    @Override
    public RecruitmentDetail findByPostIdAndUserId(Integer postId, Integer userId) {
        Optional<RecruitmentDetail> recruitmentDetailOptional =
                recruitmentDetailRepository.findFirstByPostIdAndUserId(postId,userId);
        return recruitmentDetailOptional.orElse(null);

    }
}
