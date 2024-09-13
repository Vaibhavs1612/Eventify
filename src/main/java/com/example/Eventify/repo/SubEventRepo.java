package com.example.Eventify.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Eventify.entity.SubEvent;


@Repository
public interface SubEventRepo extends JpaRepository<SubEvent, Integer> {

}
