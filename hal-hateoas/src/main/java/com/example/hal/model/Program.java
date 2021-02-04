package com.example.hal.model;

import org.springframework.hateoas.ResourceSupport;

public class Program extends ResourceSupport{
	
	private String programId;
	private String programName;
	
	public Program(String programId, String programName) {
		super();
		this.programId = programId;
		this.programName = programName;
	}
	
	public String getProgramId() {
		return programId;
	}
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	
}
