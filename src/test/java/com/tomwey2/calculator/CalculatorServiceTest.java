package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    void testSum() {
        assertEquals(5, calculatorService.sum(2, 3));
    }

    @Test
    void testSumNegativeNumbers() {
        assertEquals(-1, calculatorService.sum(-2, 1));
    }

    @Test
    void testSumLargeNumbers() {
        assertEquals(2147483646, calculatorService.sum(2147483645, 1));
    }

    @Test
    void testSubtract() {
        assertEquals(1, calculatorService.subtract(3, 2));
    }

    @Test
    void testMultiply() {
        assertEquals(6, calculatorService.multiply(2, 3));
    }
}