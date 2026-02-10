package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testDivideEndpoint() {
        ResponseEntity<String> response = restTemplate.getForEntity("/divide?a=4&b=2", String.class);
        assertEquals("2.0", response.getBody());
    }

    @Test
    void testDivideByZeroEndpoint() {
        ResponseEntity<String> response = restTemplate.getForEntity("/divide?a=4&b=0", String.class);
        assertEquals(500, response.getStatusCodeValue());
    }

}