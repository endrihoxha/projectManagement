package com.pma.controllers;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class HttpRequestTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate ; //convenient alternative of rest template suitable for integration test (like a http request )
	
	@Test
	public void homePageReturnsNumberCorrectly_thenSuccess() {
		
		String rendredHtml = this.restTemplate.getForObject("http://localhost:" + port + "/", String.class);
		
		assertEquals(rendredHtml.contains("1.0.0"),true);
	}
}
  