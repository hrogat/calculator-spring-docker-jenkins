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
}