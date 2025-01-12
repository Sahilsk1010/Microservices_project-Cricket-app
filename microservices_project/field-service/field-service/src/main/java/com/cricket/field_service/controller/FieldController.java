package com.cricket.field_service.controller;

import com.cricket.field_service.model.Field;
import com.cricket.field_service.repositories.FieldRepository;
import com.cricket.field_service.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fielders")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    // Get all fielders
    @GetMapping
    public ResponseEntity<?> getAllFielders() {
        return ResponseEntity.ok(fieldService.getAllFielders());
    }

    // Get a fielder by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getFielderById(@PathVariable int id) {
        return fieldService.getFielderById(id)
                .map(fielder -> ResponseEntity.ok(fielder))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create or update a fielder
    @PostMapping
    public ResponseEntity<Field> createOrUpdateFielder(@RequestBody Field fielder) {
        return ResponseEntity.ok(fieldService.saveFielder(fielder));
    }

    // Update an existing fielder by ID
    @PutMapping("/{id}")
    public ResponseEntity<Field> updateFielder(@PathVariable int id, @RequestBody Field fielderDetails) {
        Field updatedFielder = fieldService.updateFielder(id, fielderDetails);
        if (updatedFielder != null) {
            return new ResponseEntity<>(updatedFielder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if not found
        }
    }

    // Delete a fielder by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFielder(@PathVariable int id) {
        fieldService.deleteFielder(id);
        return ResponseEntity.ok().build();
    }
}

