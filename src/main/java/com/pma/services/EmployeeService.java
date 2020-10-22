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
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;	
	@Autowired
	ProjectRepository projectRepo;
	
	
	public String displayEmployeeFormService(Model model) {
		model.addAttribute("employee", new Employee());
		List<Project> projects=projectRepo.findAll();
		model.addAttribute("allProjects", projects);
		return "employees/new-employee";
	}
	
	
	public String saveEmployeeService(Model model, Employee employee) {
		employeeRepo.save(employee);
		
		//this is an url endpoint, not view
		return "redirect:/employees/";
	}
	
	
	public String displayEmployeesService(Model model) {
		List<Employee> employees=employeeRepo.findAll();
		model.addAttribute("employeesList", employees);
		return"/employees/list-employees";
	}
}
