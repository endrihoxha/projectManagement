package com.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pma.dao.EmployeeRepository;
import com.pma.dao.ProjectRepository;
import com.pma.dto.ChartData;
import com.pma.dto.EmployeeProject;
import com.pma.entities.Employee;
import com.pma.entities.Project;

@Service
public class HomeService {

	@Autowired
	ProjectRepository projectRepo;
	@Autowired
	EmployeeRepository employeeRepo;
	
	
	public String displayHomeService(Model model) throws JsonProcessingException {
//		Map<String, Object> map=new HashMap<>();
		
		List<Project> projects=projectRepo.findAll();
		model.addAttribute("projectsList", projects);
		
		List<Employee> employees=employeeRepo.findAll();
		model.addAttribute("employeesList", employees);
		
		List<EmployeeProject> employeeProjectCount = employeeRepo.employeeProjects();
		model.addAttribute("employeeListProjectCount", employeeProjectCount);
		
		
		
		
		List<ChartData> projectData = projectRepo.getProjectStatus();
		
//		cnvert projectData to a JSON for use in JavaScript
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonStringProjectData =objectMapper.writeValueAsString(projectData);
		model.addAttribute("potjectStatusCount", jsonStringProjectData);
		
		return "main/home";
	}


}
