package com.example.Eventify.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Eventify.entity.College;

@Repository
public interface CollegeRepo extends JpaRepository<College, Integer> {

}
	