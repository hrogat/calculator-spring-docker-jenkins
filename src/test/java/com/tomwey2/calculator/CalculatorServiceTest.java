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
    public void dividePositiveIntegersTest() {
        assertEquals(2.0, calculatorService.divide(6, 3));
    }

    @Test
    public void divideNegativeIntegersTest() {
        assertEquals(2.0, calculatorService.divide(-6, -3));
    }

    @Test
    public void divideNonIntegerResultTest() {
        assertEquals(2.5, calculatorService.divide(5, 2));
    }

    @Test
    public void divideByZeroTest() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(5, 0));
    }
}
