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
    }

    @Test
    public void divideByZeroTest() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(4, 0));
    }

    @Test
    public void divideNegativeNumbersTest() {
        assertEquals(-2.0, calculatorService.divide(-4, 2));
        assertEquals(-2.0, calculatorService.divide(4, -2));
        assertEquals(2.0, calculatorService.divide(-4, -2));
    }

    @Test
    public void divideLargeNumbersTest() {
        assertEquals(500000000.0, calculatorService.divide(1000000000, 2));
    }

    @Test
    public void divideDecimalResultTest() {
        assertEquals(1.5, calculatorService.divide(3, 2));
    }

    @Test
    public void divideOneTest() {
        assertEquals(1.0, calculatorService.divide(5, 5));
    }

    @Test
    public void divideMaxIntegerTest() {
        assertEquals(1.0, calculatorService.divide(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void divideMinIntegerTest() {
        assertEquals(1.0, calculatorService.divide(Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    @Test
    public void divideByOneTest() {
        assertEquals(5.0, calculatorService.divide(5, 1));
    }

    @Test
    public void divideZeroByNonZeroTest() {
        assertEquals(0.0, calculatorService.divide(0, 5));
    }

    @Test
    public void divideZeroByZeroTest() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(0, 0));
    }

    @Test
    public void divideNegativeByZeroTest() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(-5, 0));
    }

    @Test
    public void dividePositiveByZeroTest() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(5, 0));
    }
}