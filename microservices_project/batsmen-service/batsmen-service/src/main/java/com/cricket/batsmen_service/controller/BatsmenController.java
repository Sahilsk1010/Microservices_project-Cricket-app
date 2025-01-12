package com.cricket.batsmen_service.controller;

import com.cricket.batsmen_service.model.Batsmen;
import com.cricket.batsmen_service.service.BatsmenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/batsmen")
public class BatsmenController {

    @Autowired
    private BatsmenService batsmenService;

    // Get all batsmen
    @GetMapping
    public ResponseEntity<?> getAllBatsmen() {
        return ResponseEntity.ok(batsmenService.getAllBatsmen());
    }

    // Get a batsman by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getBatsmanById(@PathVariable int id) {
        return batsmenService.getBatsmanById(id)
                .map(batsman -> ResponseEntity.ok(batsman))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create or update a batsman
    @PostMapping
    public ResponseEntity<Batsmen> createOrUpdateBatsman(@RequestBody Batsmen batsman) {
        return ResponseEntity.ok(batsmenService.saveBatsman(batsman));
    }

    // Update an existing batsman by ID
    @PutMapping("/{id}")
    public ResponseEntity<Batsmen> updateBatsman(@PathVariable int id, @RequestBody Batsmen batsmanDetails) {
        Batsmen updatedBatsman = batsmenService.updateBatsman(id, batsmanDetails);
        if (updatedBatsman != null) {
            return new ResponseEntity<>(updatedBatsman, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if not found
        }
    }

    // Delete a batsman by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBatsman(@PathVariable int id) {
        batsmenService.deleteBatsman(id);
        return ResponseEntity.ok().build();
    }
}
