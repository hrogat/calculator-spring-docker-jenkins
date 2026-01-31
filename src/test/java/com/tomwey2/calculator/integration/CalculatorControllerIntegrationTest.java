package com.tomwey2.calculator.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSumEndpointWithValidInputs() {
        ResponseEntity<String> response = restTemplate.getForEntity("/sum?a=2&b=3", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("5", response.getBody());
    }

    @Test
    public void testSumEndpointWithZeroValues() {
        ResponseEntity<String> response = restTemplate.getForEntity("/sum?a=0&b=0", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("0", response.getBody());
    }

    @Test
    public void testSumEndpointWithNegativeValues() {
        ResponseEntity<String> response = restTemplate.getForEntity("/sum?a=-5&b=10", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("5", response.getBody());
    }

    @Test
    public void testSumEndpointWithInvalidInput() {
        ResponseEntity<String> response = restTemplate.getForEntity("/sum?a=abc&b=3", String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testSumEndpointWithMissingParameter() {
        ResponseEntity<String> response = restTemplate.getForEntity("/sum?a=5", String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testSumEndpointWithNoParameters() {
        ResponseEntity<String> response = restTemplate.getForEntity("/sum", String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}