package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class School {
	@Id
	private long schoolId;
	private String sckoolName ;
	private String sice;
	private String address;

	public long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(long schoolId) {
		this.schoolId = schoolId;
	}
	public String getSckoolName() {
		return sckoolName;
	}
	public void setSckoolName(String sckoolName) {
		this.sckoolName = sckoolName;
	}
	public String getSice() {
		return sice;
	}
	public void setSice(String sice) {
		this.sice = sice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
