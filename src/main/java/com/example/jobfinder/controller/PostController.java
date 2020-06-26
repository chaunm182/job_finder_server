package com.example.jobfinder.controller;


import com.example.jobfinder.entity.company.Company;
import com.example.jobfinder.entity.person.HRManager;
import com.example.jobfinder.entity.person.User;
import com.example.jobfinder.entity.post.JobCategory;
import com.example.jobfinder.entity.post.Post;
import com.example.jobfinder.mail.SubscribeMail;
import com.example.jobfinder.service.JobCategoryService;
import com.example.jobfinder.service.MailService;
import com.example.jobfinder.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping("/admin")
public class PostController {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private JobCategoryService jobCategoryService;

    @Autowired
    private PostService postService;

    @Autowired
    private MailService mailService;

    @GetMapping("/post/list")
    public String showListPage(Model model, HttpSession session){
        HRManager hrManager = (HRManager) session.getAttribute("account");
        Company company = hrManager.getCompany();
        List<Post> posts = postService.findPostsByCompanyId(company.getId());
        model.addAttribute("posts",posts);
        return "admin/post/list";
    }

    @GetMapping("/post/save")
    public String showSavePostPage(@RequestParam(name = "id",required = false) Integer id, Model model, HttpSession session){
        List<JobCategory> jobCategories = jobCategoryService.findAll();
        model.addAttribute("jobCategories",jobCategories);
        Post post = null;
        if(id==null){
            post=  new Post();
            HRManager hrManager = (HRManager) session.getAttribute("account");
            Company company = hrManager.getCompany();
            post.setCompany(company);
        }
        else{
          post = postService.findById(id);
        }
        model.addAttribute("post",post);
        return "admin/post/save";
    }

    @PostMapping("/post/save")
    public void addPost(@ModelAttribute("post") Post post,HttpServletResponse response) throws IOException {
        Post result = postService.save(post);
        post = result;
        if(result!=null){
            response.sendRedirect("/admin/post/save?success");
        }
        else{
            response.sendRedirect("/admin/post/save?error");
        }
    }

    @GetMapping("/post/delete")
    public void deletePost(@RequestParam("id") Integer id, HttpServletResponse response) throws IOException {
        try{
            postService.delete(id);
            response.sendRedirect("/admin/post/list?delete_success");
        }catch (Exception ex){
            logger.warning(ex.getMessage());
            response.sendRedirect("/admin/post/list?delete_error");
        }
    }


}
