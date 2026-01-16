package com.tomwey2.calculator;

import com.tomwey2.calculator.dto.SubtractionRequest;
import com.tomwey2.calculator.dto.SubtractionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CalculatorControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void subtractTest() {
        SubtractionRequest request = new SubtractionRequest(3, 2);
        ResponseEntity<SubtractionResponse> response = restTemplate.postForEntity("/subtract", request, SubtractionResponse.class);
        assertEquals(1, response.getBody().getResult());
    }

    @Test
    public void subtractNegativeNumbers() {
        SubtractionRequest request = new SubtractionRequest(3, -2);
        ResponseEntity<SubtractionResponse> response = restTemplate.postForEntity("/subtract", request, SubtractionResponse.class);
        assertEquals(5, response.getBody().getResult());
    }

    @Test
    public void subtractZero() {
        SubtractionRequest request = new SubtractionRequest(3, 0);
        ResponseEntity<SubtractionResponse> response = restTemplate.postForEntity("/subtract", request, SubtractionResponse.class);
        assertEquals(3, response.getBody().getResult());
    }

    @Test
    public void subtractLargerNumbers() {
        SubtractionRequest request = new SubtractionRequest(2, 3);
        ResponseEntity<SubtractionResponse> response = restTemplate.postForEntity("/subtract", request, SubtractionResponse.class);
        assertEquals(-1, response.getBody().getResult());
    }

    @Test
    public void subtractWithNegativeResult() {
        SubtractionRequest request = new SubtractionRequest(2, 7);
        ResponseEntity<SubtractionResponse> response = restTemplate.postForEntity("/subtract", request, SubtractionResponse.class);
        assertEquals(-5, response.getBody().getResult());
    }
}