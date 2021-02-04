package com.example.hal.model;

import org.springframework.hateoas.ResourceSupport;

public class Student extends ResourceSupport {
	
	private String studentId;
	private String studentName;
	
	public Student(String studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	

}
