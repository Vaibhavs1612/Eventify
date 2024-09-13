package com.example.Eventify.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Eventify.entity.Student;


@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
