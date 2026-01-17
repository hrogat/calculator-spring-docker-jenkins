package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CalculatorServiceTest {
    @Autowired
    private CalculatorService calculatorService;

    @Test
    public void testSum() {
        assertEquals(8, calculatorService.sum(5, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(2, calculatorService.subtract(5, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(15, calculatorService.multiply(5, 3));
    }

    @Test
    public void testSumWithNegativeNumbers() {
        assertEquals(-8, calculatorService.sum(-5, -3));
    }

    @Test
    public void testSumWithLargeNumbers() {
        assertEquals(2147483646, calculatorService.sum(2147483645, 1));
    }

    @Test
    public void testSumWithOverflow() {
        assertThrows(OverflowException.class, () -> calculatorService.sum(2147483647, 1));
    }

    @Test
    public void testSubtractWithNegativeNumbers() {
        assertEquals(-2, calculatorService.subtract(-5, -3));
    }

    @Test
    public void testMultiplyWithNegativeNumbers() {
        assertEquals(15, calculatorService.multiply(-5, -3));
    }

    @Test
    public void testMultiplyWithOverflow() {
        assertThrows(OverflowException.class, () -> calculatorService.multiply(2147483647, 2));
    }
}