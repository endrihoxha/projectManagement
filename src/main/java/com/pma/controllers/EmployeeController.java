package com.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pma.entities.Employee;
import com.pma.entities.Project;
import com.pma.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		
		return employeeService.displayEmployeeFormService(model);
	}
	
	@PostMapping("/save")
	public String saveEmployee(Model model, Employee employee) {
			
		return employeeService.saveEmployeeService(model, employee);
	}
	
	@GetMapping("")
	public String displayEmployees(Model model) {
		return employeeService.displayEmployeesService(model);
	}
	
}
