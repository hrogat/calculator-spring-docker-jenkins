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
    public void sumWithNegativeNumbers() {
        assertEquals(-1, calculatorService.sum(2, -3));
        assertEquals(-5, calculatorService.sum(-2, -3));
    }

    @Test
    public void sumWithZero() {
        assertEquals(3, calculatorService.sum(0, 3));
        assertEquals(2, calculatorService.sum(2, 0));
        assertEquals(0, calculatorService.sum(0, 0));
    }

    @Test
    public void sumWithLargeNumbers() {
        assertEquals(2147483647, calculatorService.sum(Integer.MAX_VALUE - 1, 1));
        assertEquals(-2147483647, calculatorService.sum(Integer.MIN_VALUE + 1, -1));
    }
}
