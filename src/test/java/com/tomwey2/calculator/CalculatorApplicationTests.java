package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorApplicationTests {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void contextLoads() {
    }

    @Test
    void testDivideEndpoint() {
        ResponseEntity<String> response = restTemplate.getForEntity(
            "http://localhost:" + port + "/divide?a=4&b=2",
            String.class
        );
        assertEquals("2.0", response.getBody());
    }

    @Test
    void testDivideByZeroEndpoint() {
        ResponseEntity<String> response = restTemplate.getForEntity(
            "http://localhost:" + port + "/divide?a=4&b=0",
            String.class
        );
        assertEquals("Division by zero is not allowed.", response.getBody());
    }

}