package com.pma.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pma.dao.EmployeeRepository;
import com.pma.dao.ProjectRepository;
import com.pma.services.HomeService;

@Controller
public class HomeController {

	@Autowired
	ProjectRepository projectRepo;
	@Autowired
	EmployeeRepository employeeRepo;
	@Autowired
	HomeService homeService;
	
	@Value("${version}")
	private String ver;
	
	@GetMapping("/")
	public String displayHome(Model model) throws JsonProcessingException {

		model.addAttribute("versionNumber",ver);
		return homeService.displayHomeService(model);
	}
}
