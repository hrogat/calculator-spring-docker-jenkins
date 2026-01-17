package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void sumIntegrationTest() {
        SumRequest sumRequest = new SumRequest();
        sumRequest.setA(2);
        sumRequest.setB(3);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<SumRequest> request = new HttpEntity<>(sumRequest, headers);

        ResponseEntity<SumResponse> response = restTemplate.postForEntity("/sum", request, SumResponse.class);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(5, response.getBody().getResult());
    }

    @Test
    public void sumIntegrationTestWithNegativeNumbers() {
        SumRequest sumRequest = new SumRequest();
        sumRequest.setA(-2);
        sumRequest.setB(-3);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<SumRequest> request = new HttpEntity<>(sumRequest, headers);

        ResponseEntity<SumResponse> response = restTemplate.postForEntity("/sum", request, SumResponse.class);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(-5, response.getBody().getResult());
    }

    @Test
    public void sumIntegrationTestWithZero() {
        SumRequest sumRequest = new SumRequest();
        sumRequest.setA(0);
        sumRequest.setB(0);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<SumRequest> request = new HttpEntity<>(sumRequest, headers);

        ResponseEntity<SumResponse> response = restTemplate.postForEntity("/sum", request, SumResponse.class);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, response.getBody().getResult());
    }
}