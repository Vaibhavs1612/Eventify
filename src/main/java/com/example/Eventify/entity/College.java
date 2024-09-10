package com.example.Eventify.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "College")
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int collegeId;
    
    private String collegeName;
    private String address;
    private String email;
    private String password;
	public int getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public College(int collegeId, String collegeName, String address, String email, String password) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
}
