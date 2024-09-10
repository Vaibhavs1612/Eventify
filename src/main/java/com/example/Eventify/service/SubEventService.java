package com.example.Eventify.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Eventify.entity.SubEvent;
import com.example.Eventify.repo.SubEventRepo;

import java.util.List;

@Service
public class SubEventService {

    @Autowired
    private SubEventRepo subEventRepo;

    public List<SubEvent> getAllSubEvents() {
        return subEventRepo.findAll();
    }

    public SubEvent getSubEventById(int subEventId) {
        return subEventRepo.findById(subEventId).orElse(null);
    }

    public SubEvent createOrUpdateSubEvent(SubEvent subEvent) {
        return subEventRepo.save(subEvent);
    }

    public void deleteSubEvent(int subEventId) {
        subEventRepo.deleteById(subEventId);
    }
}
