package com.example.Eventify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Eventify.entity.College;
import com.example.Eventify.repo.CollegeRepo;

@Service
public class CollegeService {

	@Autowired
    private final CollegeRepo clgRepo;
	
	 @Autowired
	 public CollegeService(CollegeRepo collegeRepository) {
	        this.clgRepo = collegeRepository;
	    }
	
	 // Get all colleges
    public List<College> getAllColleges() {
        return clgRepo.findAll();
    }

    // Get a college by ID
    public Optional<College> getCollegeById(int id) {
        return clgRepo.findById(id);
    }

    // Add a new college
    public College addCollege(College college) {
        return clgRepo.save(college);
    }

    // Update an existing college
  public College updateCollege(int collegeId, College updatedCollege) {
    // Check if the College with the given ID exists
    Optional<College> existingCollege = clgRepo.findById(collegeId);
    
    if (existingCollege.isPresent()) {
        // Update the existing college's fields with the new data
        College college = existingCollege.get();
        college.setCollegeName(updatedCollege.getCollegeName());
        college.setAddress(updatedCollege.getAddress());
        college.setEmail(updatedCollege.getEmail());
        college.setPassword(updatedCollege.getPassword());
        
        // Save the updated college entity
        return clgRepo.save(college);
    } else {
        throw new RuntimeException("College not found with id " + collegeId);
    }
}

    // Delete a college
    public void deleteCollege(int id) {
    	clgRepo.deleteById(id);
    }
}
