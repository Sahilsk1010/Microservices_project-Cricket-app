package com.cricket.batsmen_service.service;
import com.cricket.batsmen_service.model.Batsmen;
import com.cricket.batsmen_service.repositories.BatsmenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatsmenService {

    @Autowired
    private BatsmenRepository repository;  // Repository for interacting with the database

    // Get all batsmen
    public List<Batsmen> getAllBatsmen() {
        return repository.findAll();
    }

    // Get a batsman by their ID
    public Optional<Batsmen> getBatsmanById(int id) {
        return repository.findById(id);
    }

    // Save a new batsman or update an existing batsman
    public Batsmen saveBatsman(Batsmen batsman) {
        return repository.save(batsman);
    }

    // Delete a batsman by their ID
    public void deleteBatsman(int id) {
        repository.deleteById(id);
    }

    // Update an existing batsman
    public Batsmen updateBatsman(int id, Batsmen batsmanDetails) {
        // Check if the batsman with the given ID exists
        Optional<Batsmen> existingBatsmanOpt = repository.findById(id);
        if (existingBatsmanOpt.isPresent()) {
            Batsmen existingBatsman = existingBatsmanOpt.get();

            // Update the existing batsman with new details
            existingBatsman.setName(batsmanDetails.getName());
            existingBatsman.setSpan(batsmanDetails.getSpan());
            existingBatsman.setMatches(batsmanDetails.getMatches());
            existingBatsman.setInnings(batsmanDetails.getInnings());
            existingBatsman.setRuns(batsmanDetails.getRuns());
            existingBatsman.setHighScore(batsmanDetails.getHighScore());
            existingBatsman.setAverage(batsmanDetails.getAverage());
            existingBatsman.setStrikeRate(batsmanDetails.getStrikeRate());
            existingBatsman.setCenturies(batsmanDetails.getCenturies());
            existingBatsman.setFifties(batsmanDetails.getFifties());

            // Save the updated batsman
            return repository.save(existingBatsman);
        } else {
            // If the batsman with the given ID is not found, return null or throw an exception
            return null;
        }
    }
}
