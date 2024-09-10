package com.example.Eventify.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Eventify.entity.Event;

public interface EventRepo extends JpaRepository<Event, Integer> {}
