package com.example.jobfinder.rest;

import com.example.jobfinder.entity.profile.Certification;
import com.example.jobfinder.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CertificationRestController {

    @Autowired
    private CertificationService certificationService;

    @GetMapping("/certifications/profile/{id}")
    public List<Certification> findByProfileId(@PathVariable("id")Integer profileId){
        return certificationService.findByProfileId(profileId);
    }

    @GetMapping("/certifications/{id}")
    public Certification findById(@PathVariable("id")Integer id){
        return certificationService.findById(id);
    }

    @PostMapping("/certifications")
    public Certification addCertification(@RequestBody Certification certification){
        return certificationService.save(certification);
    }

    @PutMapping("/certifications")
    public Certification updateCertification(@RequestBody Certification certification){
        return certificationService.save(certification);
    }

    @DeleteMapping("/certifications/{id}")
    public void deleteById(@PathVariable("id")Integer id){
        certificationService.deleteById(id);
    }
}
