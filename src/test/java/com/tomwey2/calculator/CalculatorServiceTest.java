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
    public void multiplyTest() {
        assertEquals(6, calculatorService.multiply(2, 3));
        assertEquals(0, calculatorService.multiply(0, 5));
        assertEquals(-4, calculatorService.multiply(2, -2));
        assertEquals(4, calculatorService.multiply(-2, -2));
    }

    @Test
    public void divideTest() {
        assertEquals(2.0, calculatorService.divide(4, 2));
        assertEquals(0.5, calculatorService.divide(1, 2));
        assertEquals(-2.0, calculatorService.divide(4, -2));
        assertEquals(2.0, calculatorService.divide(-4, -2));
        assertEquals(0.0, calculatorService.divide(0, 5));
    }

    @Test
    public void divideByZeroTest() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculatorService.divide(5, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}