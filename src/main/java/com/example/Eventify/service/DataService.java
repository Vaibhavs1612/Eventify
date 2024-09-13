package com.example.Eventify.service;

import com.example.Eventify.Dto.AggregatedDataDTO;
import com.example.Eventify.entity.College;
import com.example.Eventify.entity.Student;
import com.example.Eventify.entity.Event;
import com.example.Eventify.entity.SubEvent;
import com.example.Eventify.repo.CollegeRepo;
import com.example.Eventify.repo.EventRepo;
import com.example.Eventify.repo.StudentRepo;
import com.example.Eventify.repo.SubEventRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService {

    @Autowired
    private CollegeRepo collegeRepository;

    @Autowired
    private StudentRepo studentRepository;

    @Autowired
    private EventRepo eventRepository;

    @Autowired
    private SubEventRepo subEventRepository;

    public AggregatedDataDTO getAggregatedData() {
        List<College> colleges = collegeRepository.findAll();
        List<Student> students = studentRepository.findAll();
        List<Event> events = eventRepository.findAll();
        List<SubEvent> subEvents = subEventRepository.findAll();

        return new AggregatedDataDTO(colleges, students, events, subEvents);
    }
}
