package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

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
    void testDivideEndpoint() {
        // Test normal division
        String result = restTemplate.getForObject(
            "http://localhost:" + port + "/divide?a=4&b=2", 
            String.class
        );
        assertEquals("2.0", result);

        // Test division by zero
        String errorResult = restTemplate.getForObject(
            "http://localhost:" + port + "/divide?a=4&b=0", 
            String.class
        );
        assertTrue(errorResult.contains("Division by zero is not allowed"));
    }

}