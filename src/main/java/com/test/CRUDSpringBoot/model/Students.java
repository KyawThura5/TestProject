package com.test.CRUDSpringBoot.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Students {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String name;
private Integer age;
private String email;
private String phoneNumber;
@ManyToMany
@JoinTable(
	      name = "students_courses", 
	      joinColumns = @JoinColumn(name = "students_id"), 
	      inverseJoinColumns = @JoinColumn(name = "courses_id"))  
private List<Courses> courses;
private Date registerAt;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public List<Courses> getCourses() {
	return courses;
}
public void setCourses(List<Courses> courses) {
	this.courses = courses;
}
public Date getRegisterAt() {
	return registerAt;
}
public void setRegisterAt(Date registerAt) {
	this.registerAt = registerAt;
}

}
