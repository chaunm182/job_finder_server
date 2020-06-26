package com.example.jobfinder.controller.web;

import com.example.jobfinder.entity.person.User;
import com.example.jobfinder.entity.profile.Education;
import com.example.jobfinder.service.EducationService;
import com.example.jobfinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private EducationService educationService;

    @Autowired
    private UserService userService;


    @GetMapping("")
    public String showProfilePage(Model model, HttpSession httpSession){
        User user = (User) httpSession.getAttribute("account");
        //set user session again when updated person infomation
        user = userService.findById(user.getId());
        httpSession.setAttribute("account",user);

        Integer profileId = user.getProfile().getId();
        List<Education> educations = educationService.findByProfileId(profileId);
        model.addAttribute("educations",educations);

        return "web/profile";
    }

    @GetMapping("/education")
    public String showEducationPage(Model model){
        Education education = new Education();
        model.addAttribute("educationDetail",education);
        return "web/education";
    }

    @GetMapping("/personinfo")
    public String showPersonInfomationModal(Model model,HttpSession session){
        User user = (User) session.getAttribute("account");
        model.addAttribute("user",user);
        return "web/person-infomation";
    }
}
