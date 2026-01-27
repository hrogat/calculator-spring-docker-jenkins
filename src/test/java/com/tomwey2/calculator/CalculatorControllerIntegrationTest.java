package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSumWithValidInputs() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/sum?a=5&b=3",
                String.class
        );
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("8", response.getBody());
    }

    @Test
    public void testSumWithZeroValues() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/sum?a=0&b=0",
                String.class
        );
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("0", response.getBody());
    }

    @Test
    public void testSumWithNegativeValues() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/sum?a=-5&b=-3",
                String.class
        );
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("-8", response.getBody());
    }

    @Test
    public void testSumWithMixedValues() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/sum?a=-5&b=10",
                String.class
        );
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("5", response.getBody());
    }

    @Test
    public void testSumWithInvalidInput() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/sum?a=abc&b=3",
                String.class
        );
        assertEquals(400, response.getStatusCodeValue());
    }

    @Test
    public void testSumWithMissingParameter() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/sum?a=5",
                String.class
        );
        assertEquals(400, response.getStatusCodeValue());
    }
}