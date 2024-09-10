package com.example.Eventify.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    @ManyToOne
    @JoinColumn(name = "college_id", referencedColumnName = "collegeId")
    private College college;

    private String category;
    private String name;
    private String tagline;
    private String highlight;
    private double prizePool;
    private LocalDateTime dateTime;
    private LocalDateTime deadline;
    private String rules;
    private String paymentDetails;
    private String registrationLink;

    // Assuming coordinators is a list of strings, or it could be a list of objects if more information is needed.
    @ElementCollection
    @CollectionTable(name = "event_coordinators", joinColumns = @JoinColumn(name = "event_id"))
    @Column(name = "coordinator")
    private List<String> coordinators;  // Changed from String to List<String>

    private String collegeName;
    private String collegeAddress;

    // Getters and Setters (if using Lombok's @Data, these are generated automatically)
    
    // Constructors (default and parameterized)
    public Event(int eventId, College college, String category, String name, String tagline, String highlight,
                 double prizePool, LocalDateTime dateTime, LocalDateTime deadline, String rules,
                 String paymentDetails, String registrationLink, List<String> coordinators,
                 String collegeName, String collegeAddress) {
        this.eventId = eventId;
        this.college = college;
        this.category = category;
        this.name = name;
        this.tagline = tagline;
        this.highlight = highlight;
        this.prizePool = prizePool;
        this.dateTime = dateTime;
        this.deadline = deadline;
        this.rules = rules;
        this.paymentDetails = paymentDetails;
        this.registrationLink = registrationLink;
        this.coordinators = coordinators;
        this.collegeName = collegeName;
        this.collegeAddress = collegeAddress;
    }

    public Event() {
        // Default constructor
    }

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	public double getPrizePool() {
		return prizePool;
	}

	public void setPrizePool(double prizePool) {
		this.prizePool = prizePool;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public LocalDateTime getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	public String getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(String paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public String getRegistrationLink() {
		return registrationLink;
	}

	public void setRegistrationLink(String registrationLink) {
		this.registrationLink = registrationLink;
	}

	public List<String> getCoordinators() {
		return coordinators;
	}

	public void setCoordinators(List<String> coordinators) {
		this.coordinators = coordinators;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCollegeAddress() {
		return collegeAddress;
	}

	public void setCollegeAddress(String collegeAddress) {
		this.collegeAddress = collegeAddress;
	}
}
