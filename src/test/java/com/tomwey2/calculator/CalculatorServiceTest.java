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
    public void sumTestWithZero() {
        assertEquals(3, calculatorService.sum(0, 3));
    }

    @Test
    public void sumTestWithNegativeNumbers() {
        assertEquals(-1, calculatorService.sum(2, -3));
    }

    @Test
    public void sumTestWithLargeNumbers() {
        assertEquals(2147483646, calculatorService.sum(2147483645, 1));
    }

    @Test
    public void sumTestWithMaxInteger() {
        assertEquals(Integer.MAX_VALUE, calculatorService.sum(Integer.MAX_VALUE, 0));
    }

    @Test
    public void sumTestWithMinInteger() {
        assertEquals(Integer.MIN_VALUE, calculatorService.sum(Integer.MIN_VALUE, 0));
    }
}