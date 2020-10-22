package com.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pma.dto.ChartData;
import com.pma.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

	@Query(nativeQuery=true,value="select stage as label , count(*) as value " + 
			"from project group by stage")
	public List<ChartData> getProjectStatus();
	
	
}
