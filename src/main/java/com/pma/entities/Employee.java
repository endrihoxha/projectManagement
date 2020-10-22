package com.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_id")
	private long employeeId;
	
	@Size(min=2,max=50)
	@Column(name="first_name")
	private String firstName;
	
	@Size(min=2,max=50)
	@Column(name="last_name")
	private String lastName;
	
	
	@Email
	@Column(name="email",unique=true)
	private String email;
		
//	//apply  cascading rules to children part
//	@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.LAZY)
//	@JoinColumn(name="project_id")
//	private Project theProject;  // theProject is the parent entity
	
	@ManyToMany (cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},fetch=FetchType.LAZY)
	@JoinTable(name="project_employee",
			   joinColumns=@JoinColumn(name="employee_id"),
			   inverseJoinColumns=@JoinColumn(name="project_id"))
	@JsonIgnore
	private List<Project> projects;
	
	public Employee() {

	}

	public Employee(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

//	public Project getTheProject() {
//		return theProject;
//	}
//
//	public void setTheProject(Project theProject) {
//		this.theProject = theProject;
//	}
	
	
	
}
