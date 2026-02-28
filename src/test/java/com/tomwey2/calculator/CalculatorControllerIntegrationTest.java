package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testDivideSuccess() {
        // Test division of two positive numbers
        ResponseEntity<String> response = restTemplate.getForEntity("/divide?a=4&b=2", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("2.0", response.getBody());

        // Test division of negative numbers
        response = restTemplate.getForEntity("/divide?a=-4&b=2", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("-2.0", response.getBody());
    }

    @Test
    public void testDivideByZero() {
        // Test division by zero
        ResponseEntity<String> response = restTemplate.getForEntity("/divide?a=4&b=0", String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Division by zero is not allowed.", response.getBody());
    }
}
