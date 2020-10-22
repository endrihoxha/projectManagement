package com.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pma.dto.EmployeeProject;
import com.pma.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query(nativeQuery=true,value="select e.first_name as firstName,e.last_name as lastName, e.email,count(e.employee_id) as projectCount " + 
			" from employee e left join project_employee pe on pe.employee_id = e.employee_id " + 
			" group by e.first_name,e.last_name order by 3 desc ")
	public List<EmployeeProject> employeeProjects();
}