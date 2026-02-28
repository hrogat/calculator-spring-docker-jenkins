package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService = new CalculatorService();

    @Test
    public void sumTest() {
        assertEquals(5, calculatorService.sum(2, 3));
    }

    @Test
    public void divideTest() {
        // Test division of two positive numbers
        assertEquals(2.0, calculatorService.divide(4, 2));

        // Test division of negative numbers
        assertEquals(2.0, calculatorService.divide(-4, -2));

        // Test division by zero
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.divide(4, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}
