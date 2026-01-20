package com.tomwey2.calculator;

import com.tomwey2.calculator.dto.SumResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testSumEndpoint_Success() {
        // Test with positive numbers
        ResponseEntity<SumResponse> response = restTemplate.getForEntity(
            "http://localhost:" + port + "/api/calculator/sum?a=5&b=3",
            SumResponse.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(8, response.getBody().getResult());
    }

    @Test
    void testSumEndpoint_WithNegativeNumbers() {
        ResponseEntity<SumResponse> response = restTemplate.getForEntity(
            "http://localhost:" + port + "/api/calculator/sum?a=-5&b=-3",
            SumResponse.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(-8, response.getBody().getResult());
    }

    @Test
    void testSumEndpoint_WithZero() {
        ResponseEntity<SumResponse> response = restTemplate.getForEntity(
            "http://localhost:" + port + "/api/calculator/sum?a=0&b=5",
            SumResponse.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(5, response.getBody().getResult());
    }

    @Test
    void testSumEndpoint_WithLargeNumbers() {
        ResponseEntity<SumResponse> response = restTemplate.getForEntity(
            "http://localhost:" + port + "/api/calculator/sum?a=1000000000&b=1000000000",
            SumResponse.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2000000000, response.getBody().getResult());
    }

    @Test
    void testSumEndpoint_InvalidInput() {
        ResponseEntity<String> response = restTemplate.getForEntity(
            "http://localhost:" + port + "/api/calculator/sum?a=abc&b=5",
            String.class
        );

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertTrue(response.getBody().contains("Invalid number format"));
    }

    @Test
    void testSumEndpoint_MissingParameter() {
        ResponseEntity<String> response = restTemplate.getForEntity(
            "http://localhost:" + port + "/api/calculator/sum?a=5",
            String.class
        );

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testSumEndpoint_EmptyParameters() {
        ResponseEntity<String> response = restTemplate.getForEntity(
            "http://localhost:" + port + "/api/calculator/sum?a=&b=",
            String.class
        );

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}