package com.example.Eventify.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Eventify.entity.Event;
import com.example.Eventify.repo.EventRepo;

import java.util.List;

@Service
public class EventService {
    
    @Autowired
    private EventRepo eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(int eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    public Event createOrUpdateEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(int eventId) {
        eventRepository.deleteById(eventId);
    }
}

