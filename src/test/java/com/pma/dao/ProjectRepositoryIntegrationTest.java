package com.pma.dao;





import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.pma.ProjectManagementApplication;
import com.pma.dao.ProjectRepository;
import com.pma.entities.Project;


@SpringBootTest
//@ContextConfiguration(classes=ProjectManagementApplication.class)// ProjectManagementApplication ==> this is the application starting point  
@RunWith(SpringRunner.class) // it is needed for JUnit for testing
//@DataJpaTest  // to write test cases for inmemory DB
@SqlGroup(value = { @Sql (executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts= {"classpath:schema.sql","classpath:data.sql"})
//				  , @Sql (executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts="classpath:drop.sql")
})

public class ProjectRepositoryIntegrationTest {
//it is going to test the project repository in this class

	
	@Autowired
	ProjectRepository proRepo;
	
	@Test
	public void ifNewProjectSaved_thenSuccess() {
		Project newProject = new Project("New Test Project", "COMPLETE", "Test Description");
		proRepo.save(newProject);
		
		assertEquals(5, proRepo.findAll().size());
	}

}
