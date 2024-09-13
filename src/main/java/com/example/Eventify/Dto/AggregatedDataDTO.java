package com.example.Eventify.Dto;

import java.util.List;

import com.example.Eventify.entity.College;
import com.example.Eventify.entity.Event;
import com.example.Eventify.entity.Student;
import com.example.Eventify.entity.SubEvent;

import lombok.Data;

@Data
public class AggregatedDataDTO {
	
	private List<College> colleges;
    private List<Student> students;
    private List<Event> events;
    private List<SubEvent> subEvents;

    public AggregatedDataDTO(List<College> colleges, List<Student> students, List<Event> events, List<SubEvent> subEvents) {
        this.colleges = colleges;
        this.students = students;
        this.events = events;
        this.subEvents = subEvents;
    }

	public List<College> getColleges() {
		return colleges;
	}

	public void setColleges(List<College> colleges) {
		this.colleges = colleges;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<SubEvent> getSubEvents() {
		return subEvents;
	}

	public void setSubEvents(List<SubEvent> subEvents) {
		this.subEvents = subEvents;
	}
    
}
