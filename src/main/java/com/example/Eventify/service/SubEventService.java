package com.example.Eventify.service;

import com.example.Eventify.entity.SubEvent;
import com.example.Eventify.repo.SubEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubEventService {

    @Autowired
    private SubEventRepo subEventRepository;

    // Create a new SubEvent
    public SubEvent createSubEvent(SubEvent subEvent) {
        return subEventRepository.save(subEvent);
    }

    // Get all SubEvents
    public List<SubEvent> getAllSubEvents() {
        return subEventRepository.findAll();
    }

    // Get a SubEvent by ID
    public Optional<SubEvent> getSubEventById(int subEventId) {
        return subEventRepository.findById(subEventId);
    }

    // Update a SubEvent
    public SubEvent updateSubEvent(int subEventId, SubEvent updatedSubEvent) {
        if (subEventRepository.existsById(subEventId)) {
            updatedSubEvent.setSubEventId(subEventId);
            return subEventRepository.save(updatedSubEvent);
        } else {
            throw new RuntimeException("SubEvent not found with id " + subEventId);
        }
    }

    // Delete a SubEvent by ID
    public void deleteSubEvent(int subEventId) {
        if (subEventRepository.existsById(subEventId)) {
            subEventRepository.deleteById(subEventId);
        } else {
            throw new RuntimeException("SubEvent not found with id " + subEventId);
        }
    }
}
