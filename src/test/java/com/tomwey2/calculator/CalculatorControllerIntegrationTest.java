package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testDivideEndpoint() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/divide?a=6&b=2",
                String.class
        );
        assertEquals("3.0", response.getBody());
    }

    @Test
    public void testDivideEndpointWithNonIntegerResult() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/divide?a=5&b=2",
                String.class
        );
        assertEquals("2.5", response.getBody());
    }

    @Test
    public void testDivideByZeroEndpoint() {
        ResponseEntity<String> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/divide?a=5&b=0",
                String.class
        );
        assertEquals(400, response.getStatusCodeValue());
    }
}