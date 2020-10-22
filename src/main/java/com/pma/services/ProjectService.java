package com.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pma.dao.EmployeeRepository;
import com.pma.dao.ProjectRepository;
import com.pma.entities.Employee;
import com.pma.entities.Project;

@Service
public class ProjectService {

	
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	
	//model is used to exchange data between the view and the controller
	public String displayProjectFormService(Model model) {
		// bind and empty project to the form ==> "new Project()"
		model.addAttribute("theProject", new Project());
		
		
		//add the list of the employees to the form  
		List<Employee> employees=employeeRepo.findAll();
		model.addAttribute("allEmployees",employees);
		
		
		return"projects/new-project";
	}
	 
	
	
	public String saveProjectService(Project theProject, Model model) {
		projectRepo.save(theProject); //spring understands the relation "many to many"
		// !!! use redirect to prevent duplicate submissions
		return"redirect:/projects";
	}
	
	
	public String displayProjectsService(Model model) {
		List<Project> projects=projectRepo.findAll();
		model.addAttribute("projectsList", projects);
		return"/projects/list-projects";
	}
}
