package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void testDivideEndpointWithValidInput() {
		ResponseEntity<String> response = restTemplate.getForEntity(
			"http://localhost:" + port + "/divide?a=10&b=2", 
			String.class
		);
		assertEquals("5.0", response.getBody());
	}

	@Test
	void testDivideEndpointWithDecimalResult() {
		ResponseEntity<String> response = restTemplate.getForEntity(
			"http://localhost:" + port + "/divide?a=10&b=3", 
			String.class
		);
		assertEquals("3.3333333333333335", response.getBody());
	}

	@Test
	void testDivideEndpointWithNegativeNumbers() {
		ResponseEntity<String> response = restTemplate.getForEntity(
			"http://localhost:" + port + "/divide?a=-10&b=2", 
			String.class
		);
		assertEquals("-5.0", response.getBody());
	}

	@Test
	void testDivideEndpointWithDivisionByZero() {
		ResponseEntity<String> response = restTemplate.getForEntity(
			"http://localhost:" + port + "/divide?a=10&b=0", 
			String.class
		);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}
}