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
    }

    @Test
    public void subtractZeroTest() {
        assertEquals(5, calculatorService.subtract(5, 0));
    }

    @Test
    public void subtractNegativeFromPositiveTest() {
        assertEquals(7, calculatorService.subtract(5, -2));
    }

    @Test
    public void subtractPositiveFromNegativeTest() {
        assertEquals(-7, calculatorService.subtract(-5, 2));
    }

    @Test
    public void subtractTwoNegativesTest() {
        assertEquals(-3, calculatorService.subtract(-5, -2));
    }

    @Test
    public void subtractLargerFromSmallerTest() {
        assertEquals(-1, calculatorService.subtract(2, 3));
    }
}