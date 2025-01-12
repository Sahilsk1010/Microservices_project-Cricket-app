package com.cricket.bowler_service.service;

import com.cricket.bowler_service.model.Bowler;
import com.cricket.bowler_service.repositories.BowlerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BowlerService {

    @Autowired
    private BowlerRepository repository;

    // Get all bowlers
    public List<Bowler> getAllBowlers() {
        return repository.findAll();
    }

    // Get a bowler by ID
    public Optional<Bowler> getBowlerById(int id) {
        return repository.findById(id);
    }

    // Save a new bowler or update an existing bowler
    public Bowler saveBowler(Bowler bowler) {
        return repository.save(bowler);
    }

    // Delete a bowler by ID
    public void deleteBowler(int id) {
        repository.deleteById(id);
    }

    // Update an existing bowler
    public Bowler updateBowler(int id, Bowler bowlerDetails) {
        Optional<Bowler> existingBowlerOpt = repository.findById(id);
        if (existingBowlerOpt.isPresent()) {
            Bowler existingBowler = existingBowlerOpt.get();

            existingBowler.setName(bowlerDetails.getName());
            existingBowler.setSpan(bowlerDetails.getSpan());
            existingBowler.setMatches(bowlerDetails.getMatches());
            existingBowler.setWickets(bowlerDetails.getWickets());
            existingBowler.setBestBowling(bowlerDetails.getBestBowling());
            existingBowler.setAverage(bowlerDetails.getAverage());
            existingBowler.setEconomyRate(bowlerDetails.getEconomyRate());
            existingBowler.setStrikeRate(bowlerDetails.getStrikeRate());
            existingBowler.setFourWickets(bowlerDetails.getFourWickets());
            existingBowler.setFiveWickets(bowlerDetails.getFiveWickets());

            return repository.save(existingBowler);
        } else {
            return null;  // Return null or throw an exception if not found
        }
    }
}
