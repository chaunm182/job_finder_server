package com.example.jobfinder.repository;

import com.example.jobfinder.entity.post.RecruitmentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecruitmentDetailRepository extends JpaRepository<RecruitmentDetail,Integer> {
    List<RecruitmentDetail> findRecruitmentDetailsByPostId(Integer postId);
    Optional<RecruitmentDetail> findFirstByPostIdAndUserId(Integer postId, Integer userId);
}
