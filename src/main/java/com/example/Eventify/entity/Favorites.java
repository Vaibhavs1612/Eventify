package com.example.Eventify.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Favorites")
public class Favorites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int favoriteId;
    
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    private Student student;
    
    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "eventId")
    private Event event;

	public int getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Favorites(int favoriteId, Student student, Event event) {
		super();
		this.favoriteId = favoriteId;
		this.student = student;
		this.event = event;
	}

	public Favorites() {
		super();
		// TODO Auto-generated constructor stub
	}
}
