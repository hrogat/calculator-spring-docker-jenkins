package com.tomwey2.calculator.controller;

import com.tomwey2.calculator.dto.SumRequest;
import com.tomwey2.calculator.dto.SumResponse;
import com.tomwey2.calculator.exception.InvalidInputException;
import com.tomwey2.calculator.exception.OverflowException;
import com.tomwey2.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculatorControllerTest {

    @Mock
    private CalculatorService calculatorService;

    @InjectMocks
    private CalculatorController calculatorController;

    @Test
    public void testSumValidInput() {
        SumRequest sumRequest = new SumRequest(2, 3);
        when(calculatorService.sum(2, 3)).thenReturn(5);

        ResponseEntity<SumResponse> response = calculatorController.sum(sumRequest);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(5, response.getBody().getResult());
    }

    @Test
    public void testSumInvalidInput() {
        SumRequest sumRequest = new SumRequest(0, 3);
        when(calculatorService.sum(0, 3)).thenThrow(new InvalidInputException("Input values cannot be zero."));

        assertThrows(InvalidInputException.class, () -> calculatorController.sum(sumRequest));
    }

    @Test
    public void testSumOverflow() {
        SumRequest sumRequest = new SumRequest(Integer.MAX_VALUE, 1);
        when(calculatorService.sum(Integer.MAX_VALUE, 1)).thenThrow(new OverflowException("Sum exceeds maximum integer value."));

        assertThrows(OverflowException.class, () -> calculatorController.sum(sumRequest));
    }
}