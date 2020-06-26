package com.example.jobfinder.rest;

import com.example.jobfinder.entity.profile.Project;
import com.example.jobfinder.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectRestController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects/profile/{id}")
    public List<Project> findByProfileId(@PathVariable("id")Integer profileId){
        return projectService.findByProfileId(profileId);
    }

    @GetMapping("/projects/{id}")
    public Project findById(@PathVariable("id")Integer id){
        return projectService.findById(id);
    }

    @PostMapping("/projects")
    public Project addProject(@RequestBody Project project){
        return projectService.save(project);
    }

    @PutMapping("/projects")
    public Project updateProject(@RequestBody Project project){
        return projectService.save(project);
    }

    @DeleteMapping("/projects/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        projectService.deleteById(id);
    }
}
