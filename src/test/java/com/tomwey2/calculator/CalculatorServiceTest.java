package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void sum() {
        assertEquals(5, calculatorService.sum(2, 3));
    }

    @Test
    void divide() {
        assertEquals(5.0, calculatorService.divide(10, 2));
        assertEquals(-5.0, calculatorService.divide(-10, 2));
        assertEquals(2.5, calculatorService.divide(5, 2));
    }

    @Test
    void divideByZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.divide(10, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}