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
        assertEquals(2.0, calculatorService.divide(4, 2));
        assertEquals(1.5, calculatorService.divide(3, 2));
        assertEquals(-2.0, calculatorService.divide(-4, 2));
        assertEquals(2.0, calculatorService.divide(-4, -2));
    }

    @Test
    public void divideByZeroTest() {
        assertThrows(DivisionByZeroException.class, () -> calculatorService.divide(1, 0));
    }
}
