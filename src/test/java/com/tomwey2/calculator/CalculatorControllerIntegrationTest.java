package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSumEndpoint() {
        String result = restTemplate.getForObject(
            "http://localhost:" + port + "/sum?a=2&b=3", 
            String.class
        );
        assertEquals("5", result);
    }

    @Test
    public void testMultiplyEndpoint() {
        String result = restTemplate.getForObject(
            "http://localhost:" + port + "/multiply?a=2&b=3", 
            String.class
        );
        assertEquals("6", result);
    }
}
