package com.cricket.field_service.service;

import com.cricket.field_service.model.Field;
import com.cricket.field_service.repositories.FieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FieldService {

    @Autowired
    private FieldRepository repository;  // Repository for interacting with the database

    // Get all fielders
    public List<Field> getAllFielders() {
        return repository.findAll();
    }

    // Get a fielder by their ID
    public Optional<Field> getFielderById(int id) {
        return repository.findById(id);
    }

    // Save a new fielder or update an existing fielder
    public Field saveFielder(Field fielder) {
        return repository.save(fielder);
    }

    // Delete a fielder by their ID
    public void deleteFielder(int id) {
        repository.deleteById(id);
    }

    // Update an existing fielder
    public Field updateFielder(int id, Field fielderDetails) {
        Optional<Field> existingFielderOpt = repository.findById(id);
        if (existingFielderOpt.isPresent()) {
            Field existingFielder = existingFielderOpt.get();

            existingFielder.setName(fielderDetails.getName());
            existingFielder.setSpan(fielderDetails.getSpan());
            existingFielder.setMatches(fielderDetails.getMatches());
            existingFielder.setCatches(fielderDetails.getCatches());
            existingFielder.setStumpings(fielderDetails.getStumpings());
            existingFielder.setRunOuts(fielderDetails.getRunOuts());
            existingFielder.setTotalFielding(fielderDetails.getTotalFielding());

            return repository.save(existingFielder);
        } else {
            return null;  // Return null or throw an exception if the fielder is not found
        }
    }
}
