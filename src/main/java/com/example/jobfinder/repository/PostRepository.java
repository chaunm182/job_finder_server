package com.example.jobfinder.repository;

import com.example.jobfinder.entity.post.Post;
import javafx.geometry.Pos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findByJobNameLike(String jobName);

    List<Post> findPostsByCompanyId(Integer companyId);

    @Query("SELECT DISTINCT p.address FROM Post p")
    List<String> findAllAddress();

    List<Post> findPostsByJobNameLikeAndJobCategoryIdAndAddress(String jobName,Integer jobCategoryId,String address);
}
