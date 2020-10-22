package com.pma.dto;

public interface EmployeeProject {

//	here we declare the properties, they should start with get, spring data will understand them
//	Need to have property names begin with get
	public String getFirstName();
	public String getLastName();
	public String getEmail();
	public String getProjectCount();
}
