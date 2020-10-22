package com.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pma.entities.Project;
import com.pma.services.ProjectService;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@GetMapping("/new")
	//model is used to exchange data between the view and the controller
	public String displayProjectForm(Model model) {
		
		return projectService.displayProjectFormService(model);
	}
	 
	// FOR 1 TO MANY  (1 PROJECT --> n EMPLOYEES)
	
//	@PostMapping("/save")
//	public String saveProject(Project project, Model model,@RequestParam List<Long> employees) {
	
	//save project
//		projectRepo.save(project);
//		
	//find employees by the given id in the list of employees
//		List<Employee> choosenEmployees = employeeRepo.findAllById(employees);
//		for(Employee empl : choosenEmployees) {
//			empl.setTheProject(project);
	//save employee
//			employeeRepo.save(empl);
//		}
//		// !!! use redirect to prevent duplicate submissions
//		return"redirect:/projects/new";
//	}
	
	@PostMapping("/save")
	public String saveProject(Project theProject, Model model) {
		return projectService.saveProjectService(theProject, model);
	}
	
	@GetMapping("")
	public String displayProjects(Model model) {
		return projectService.displayProjectsService(model);
	}

}
