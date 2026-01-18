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
    public void multiplyIntegrationTest() {
        String result = restTemplate.getForObject("http://localhost:" + port + "/multiply?a=2&b=3", String.class);
        assertEquals("6", result);
    }

    @Test
    public void divideIntegrationTest() {
        String result = restTemplate.getForObject("http://localhost:" + port + "/divide?a=4&b=2", String.class);
        assertEquals("2.0", result);
    }

    @Test
    public void divideByZeroIntegrationTest() {
        String result = restTemplate.getForObject("http://localhost:" + port + "/divide?a=4&b=0", String.class);
        assertTrue(result.contains("Division by zero is not allowed"));
    }
}