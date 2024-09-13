package com.example.Eventify.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Eventify.entity.College;
import com.example.Eventify.service.CollegeService;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

	@Autowired
    private CollegeService collegeService;

    // Get all colleges
    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    // Get a college by ID
    @GetMapping("/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable int id) {
        Optional<College> college = collegeService.getCollegeById(id);
        return college.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new college
    @PostMapping
    public College addCollege(@RequestBody College college) {
        return collegeService.addCollege(college);
    }

    // Update an existing college
    @PutMapping("/{id}")
    public ResponseEntity<College> updateCollege(@PathVariable int id, @RequestBody College updatedCollege) {
        try {
            College college = collegeService.updateCollege(id, updatedCollege);
            return ResponseEntity.ok(college);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a college
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCollege(@PathVariable int id) {
        try {
            collegeService.deleteCollege(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
