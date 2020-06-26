package com.example.jobfinder.serviceimpl;

import com.example.jobfinder.entity.post.Post;
import com.example.jobfinder.repository.CustomizePostRepository;
import com.example.jobfinder.repository.PostRepository;
import com.example.jobfinder.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CustomizePostRepository customizePostRepository;

    @Override
    public List<Post> findAll() {
        Sort sort = Sort.by("id").descending();
        return postRepository.findAll(sort);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);

    }

    @Override
    public List<Post> findPostsByCompanyId(Integer id) {
        return postRepository.findPostsByCompanyId(id);
    }

    @Override
    public void delete(Integer id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post findById(Integer id) {
        Optional<Post> postOptional = postRepository.findById(id);
        return postOptional.orElse(null);
    }

    @Override
    public List<String> findAllAddress() {
        return postRepository.findAllAddress();
    }

    @Override
    public List<Post> search(String jobName, Integer jobCategoryId, String address) {
        jobName = "%"+jobName+"%";
        return postRepository.findPostsByJobNameLikeAndJobCategoryIdAndAddress(jobName,jobCategoryId,address);
    }

    @Override
    public List<Post> findByJobNameLike(String jobName) {
        jobName = "%"+jobName+"%";
        return postRepository.findByJobNameLike(jobName);
    }

    @Override
    @Transactional
    public List<Post> findByProps(Map<String, String> props) {
        Set<String> keys = props.keySet();
        Map<String,String> map = new HashMap<>();
        for(String key : keys){
            String value = props.get(key);
            if(!(value.equals("all") || value.equals("0"))){
                map.put(key,value);
            }
        }
        return customizePostRepository.findByProperties(map);
    }
}
