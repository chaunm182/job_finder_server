package com.example.jobfinder.rest;

import com.example.jobfinder.entity.profile.Prize;
import com.example.jobfinder.entity.profile.Profile;
import com.example.jobfinder.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PrizeRestController {

    @Autowired
    private PrizeService prizeService;

    @GetMapping("/prizes/profile/{profileId}")
    public List<Prize> findByProfileId(@PathVariable("profileId")Integer profileId){
        return prizeService.findByProfileId(profileId);
    }

    @GetMapping("/prizes/{id}")
    public Prize findById(@PathVariable("id")Integer id){
        return prizeService.findById(id);
    }

    @PostMapping("/prizes")
    public Prize addPrize(@RequestBody Prize prize){
        return prizeService.save(prize);
    }

    @PutMapping("/prizes")
    public Prize updatePrize(@RequestBody Prize prize){
        return prizeService.save(prize);
    }

    @DeleteMapping("/prizes/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        prizeService.deleteById(id);
    }
}
