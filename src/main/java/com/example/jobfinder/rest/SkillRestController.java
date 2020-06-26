package com.example.jobfinder.rest;

import com.example.jobfinder.entity.profile.Skill;
import com.example.jobfinder.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SkillRestController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/skills/profile/{id}")
    public List<Skill> findByProfileId(@PathVariable("id")Integer profileId){
        return skillService.findByProfileId(profileId);
    }

    @GetMapping("/skills/{id}")
    public Skill findById(@PathVariable("id")Integer id){
        return skillService.findById(id);
    }

    @PostMapping("/skills")
    public Skill addSkill(@RequestBody Skill skill){
        return  skillService.save(skill);
    }

    @PutMapping("/skills")
    public Skill updateSkill(@RequestBody Skill skill){
        return skillService.save(skill);
    }

    @DeleteMapping("/skills/{id}")
    public void deleteById(@PathVariable("id")Integer id){
        skillService.deleteById(id);
    }
}
