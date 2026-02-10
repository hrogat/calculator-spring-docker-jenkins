package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void divide_Success() {
		ResponseEntity<String> response = restTemplate.getForEntity(
				"/divide?a=4&b=2", 
					String.class
		);
		assertEquals("2.0", response.getBody());
	}

	@Test
	void divide_ByZero() {
		ResponseEntity<String> response = restTemplate.getForEntity(
				"/divide?a=5&b=0", 
					String.class
		);
		assertEquals("Error: Division by zero is not allowed.", response.getBody());
	}
}