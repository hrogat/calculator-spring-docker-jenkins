package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CalculatorService calculatorService;

    @Test
    void contextLoads() {
        // Basic context loading test
        assertNotNull(calculatorService);
    }

    @Test
    void testApplicationStartsAndServiceIsAvailable() {
        // Test that the service layer is working
        int result = calculatorService.sum(10, 20);
        assertEquals(30, result);
    }

    @Test
    void testBasicEndpointAvailability() {
        // Test that the basic endpoint is accessible
        ResponseEntity<String> response = restTemplate.getForEntity("/sum?a=17&b=18", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("35", response.getBody());
    }
}
