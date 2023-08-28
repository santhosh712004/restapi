package com.example.demo.model;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
@Entity
public class Student {
@Id
@GeneratedValue
private long studentId;
private String rollno;
private String name;
private String address;
@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name="foreignkey", referencedColumnName="studentId")
private List<School> school;
public long getStudentId() {
	return studentId;
}
public void setStudentId(long studentId) {
	this.studentId = studentId;
}
public String getRollno() {
	return rollno;
}
public void setRollno(String rollno) {
	this.rollno = rollno;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public List<School> getSchool() {
	return school;
}
public void setSchool(List<School> school) {
	this.school = school;
} 

}
