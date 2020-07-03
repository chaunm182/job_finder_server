package com.example.jobfinder.rest;

import com.example.jobfinder.entity.profile.Education;
import com.example.jobfinder.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EducationRestController {

    @Autowired
    private EducationService educationService;

    @GetMapping("/educations/profile/{id}")
    public List<Education> findByProfileId(@PathVariable("id") Integer id){
        return educationService.findByProfileId(id);
    }

    @GetMapping("/educations/{id}")
    public Education findById(@PathVariable("id")Integer id){
        return educationService.findById(id);
    }


    @PostMapping("/educations")
    public Education addEducation(@RequestBody Education education){
        return educationService.save(education);
    }

    @PutMapping("/educations")
    public Education updateEducation(@RequestBody Education education){
        return educationService.save(education);
    }

    @DeleteMapping("/educations/{id}")
    public void deleteEducation(@PathVariable("id") Integer id){
        educationService.deleteById(id);
    }
}
