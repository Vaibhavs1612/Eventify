package com.example.Eventify.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "subevent")
public class SubEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subEventId;
    
    @ManyToOne
    @JoinColumn(name = "event_id", referencedColumnName = "eventId")
    private Event event;
    
    private String branch;
    
    // Remove JSON column definition if not required by your DB
    private String description;
    
    // Use ElementCollection to map List<String>
    @ElementCollection
    @CollectionTable(name = "student_coordinators", joinColumns = @JoinColumn(name = "subEvent_id"))
    @Column(name = "coordinator_name")
    private List<String> studentCoordinators;

    private int availableSeats;
    private double prizeRank1;
    private double prizeRank2;
    private double prizeRank3;
    private LocalDateTime timingDate;
    private double entryFees;

    // Constructor, Getters, and Setters
    public SubEvent(int subEventId, Event event, String branch, String description, List<String> studentCoordinators,
                    int availableSeats, double prizeRank1, double prizeRank2, double prizeRank3, LocalDateTime timingDate,
                    double entryFees) {
        this.subEventId = subEventId;
        this.event = event;
        this.branch = branch;
        this.description = description;
        this.studentCoordinators = studentCoordinators;
        this.availableSeats = availableSeats;
        this.prizeRank1 = prizeRank1;
        this.prizeRank2 = prizeRank2;
        this.prizeRank3 = prizeRank3;
        this.timingDate = timingDate;
        this.entryFees = entryFees;
    }

    public SubEvent() {
        // Default constructor
    }

	public int getSubEventId() {
		return subEventId;
	}

	public void setSubEventId(int subEventId) {
		this.subEventId = subEventId;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getStudentCoordinators() {
		return studentCoordinators;
	}

	public void setStudentCoordinators(List<String> studentCoordinators) {
		this.studentCoordinators = studentCoordinators;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public double getPrizeRank1() {
		return prizeRank1;
	}

	public void setPrizeRank1(double prizeRank1) {
		this.prizeRank1 = prizeRank1;
	}

	public double getPrizeRank2() {
		return prizeRank2;
	}

	public void setPrizeRank2(double prizeRank2) {
		this.prizeRank2 = prizeRank2;
	}

	public double getPrizeRank3() {
		return prizeRank3;
	}

	public void setPrizeRank3(double prizeRank3) {
		this.prizeRank3 = prizeRank3;
	}

	public LocalDateTime getTimingDate() {
		return timingDate;
	}

	public void setTimingDate(LocalDateTime timingDate) {
		this.timingDate = timingDate;
	}

	public double getEntryFees() {
		return entryFees;
	}

	public void setEntryFees(double entryFees) {
		this.entryFees = entryFees;
	}

    // Getters and Setters
    // You can keep them or rely on Lombok @Data annotation
}
