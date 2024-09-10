package com.example.Eventify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Eventify.entity.SubEvent;
import com.example.Eventify.service.SubEventService;

import java.util.List;

@RestController
@RequestMapping("/api/subevents")
public class SubEventController {

    @Autowired
    private SubEventService subEventService;

    @GetMapping
    public List<SubEvent> getAllSubEvents() {
        return subEventService.getAllSubEvents();
    }

    @GetMapping("/{subEventId}")
    public ResponseEntity<SubEvent> getSubEventById(@PathVariable int subEventId) {
        SubEvent subEvent = subEventService.getSubEventById(subEventId);
        return subEvent != null ? ResponseEntity.ok(subEvent) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public SubEvent createSubEvent(@RequestBody SubEvent subEvent) {
        return subEventService.createOrUpdateSubEvent(subEvent);
    }

    @PutMapping("/{subEventId}")
    public ResponseEntity<SubEvent> updateSubEvent(@PathVariable int subEventId, @RequestBody SubEvent subEvent) {
        SubEvent existingSubEvent = subEventService.getSubEventById(subEventId);
        if (existingSubEvent != null) {
            subEvent.setSubEventId(subEventId);
            return ResponseEntity.ok(subEventService.createOrUpdateSubEvent(subEvent));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{subEventId}")
    public ResponseEntity<Void> deleteSubEvent(@PathVariable int subEventId) {
        subEventService.deleteSubEvent(subEventId);
        return ResponseEntity.noContent().build();
    }
}
