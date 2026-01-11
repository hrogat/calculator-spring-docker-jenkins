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
    public void subtractTest() {
        assertEquals(1, calculatorService.subtract(3, 2));
        assertEquals(-1, calculatorService.subtract(2, 3));
        assertEquals(0, calculatorService.subtract(5, 5));
    }

    @Test
    public void powerTest() {
        assertEquals(8.0, calculatorService.power(2.0, 3.0));
        assertEquals(1.0, calculatorService.power(5.0, 0.0));
        assertEquals(0.25, calculatorService.power(2.0, -2.0));
        assertEquals(16.0, calculatorService.power(-2.0, 4.0));
    }
}