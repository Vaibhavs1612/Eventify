package com.example.Eventify.controller;

import com.example.Eventify.entity.SubEvent;
import com.example.Eventify.service.SubEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subevents")
public class SubEventController {

    @Autowired
    private SubEventService subEventService;

    // Create a new SubEvent
    @PostMapping
    public ResponseEntity<SubEvent> createSubEvent(@RequestBody SubEvent subEvent) {
        SubEvent createdSubEvent = subEventService.createSubEvent(subEvent);
        return new ResponseEntity<>(createdSubEvent, HttpStatus.CREATED);
    }

    // Get all SubEvents
    @GetMapping
    public ResponseEntity<List<SubEvent>> getAllSubEvents() {
        List<SubEvent> subEvents = subEventService.getAllSubEvents();
        return new ResponseEntity<>(subEvents, HttpStatus.OK);
    }

    // Get a SubEvent by ID
    @GetMapping("/{id}")
    public ResponseEntity<SubEvent> getSubEventById(@PathVariable("id") int subEventId) {
        Optional<SubEvent> subEvent = subEventService.getSubEventById(subEventId);
        return subEvent.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a SubEvent
    @PutMapping("/{id}")
    public ResponseEntity<SubEvent> updateSubEvent(@PathVariable("id") int subEventId, @RequestBody SubEvent updatedSubEvent) {
        try {
            SubEvent subEvent = subEventService.updateSubEvent(subEventId, updatedSubEvent);
            return new ResponseEntity<>(subEvent, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Delete a SubEvent
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubEvent(@PathVariable("id") int subEventId) {
        try {
            subEventService.deleteSubEvent(subEventId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
