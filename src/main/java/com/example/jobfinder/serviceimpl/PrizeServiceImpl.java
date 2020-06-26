package com.example.jobfinder.serviceimpl;

import com.example.jobfinder.entity.profile.Prize;
import com.example.jobfinder.repository.PrizeRepository;
import com.example.jobfinder.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrizeServiceImpl implements PrizeService {

    @Autowired
    private PrizeRepository prizeRepository;

    @Override
    public List<Prize> findByProfileId(Integer profileId) {
        return prizeRepository.findByProfileId(profileId);
    }

    @Override
    public Prize findById(Integer id) {
        Optional<Prize> prizeOptional =  prizeRepository.findById(id);
        return prizeOptional.orElse(null);
    }

    @Override
    public Prize save(Prize prize) {
        return prizeRepository.save(prize);
    }

    @Override
    public void deleteById(Integer id) {
        prizeRepository.deleteById(id);
    }
}
