package com.cricket.bowler_service.controller;

//import com.cricket.CrickInfoBackend.entities.Bowler;
//import com.cricket.CrickInfoBackend.services.impl.BowlerService;
import com.cricket.bowler_service.model.Bowler;
import com.cricket.bowler_service.service.BowlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bowlers")
public class BowlerController {

    @Autowired
    private BowlerService bowlerService;

    // Get all bowlers
    @GetMapping
    public ResponseEntity<?> getAllBowlers() {
        return ResponseEntity.ok(bowlerService.getAllBowlers());
    }

    // Get a bowler by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getBowlerById(@PathVariable int id) {
        return bowlerService.getBowlerById(id)
                .map(bowler -> ResponseEntity.ok(bowler))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create or update a bowler
    @PostMapping
    public ResponseEntity<Bowler> createOrUpdateBowler(@RequestBody Bowler bowler) {
        return ResponseEntity.ok(bowlerService.saveBowler(bowler));
    }

    // Update an existing bowler by ID
    @PutMapping("/{id}")
    public ResponseEntity<Bowler> updateBowler(@PathVariable int id, @RequestBody Bowler bowlerDetails) {
        Bowler updatedBowler = bowlerService.updateBowler(id, bowlerDetails);
        if (updatedBowler != null) {
            return new ResponseEntity<>(updatedBowler, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if not found
        }
    }

    // Delete a bowler by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBowler(@PathVariable int id) {
        bowlerService.deleteBowler(id);
        return ResponseEntity.ok().build();
    }
}
