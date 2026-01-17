package com.tomwey2.calculator.service;

import com.tomwey2.calculator.exception.InvalidInputException;
import com.tomwey2.calculator.exception.OverflowException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testSumValidInput() {
        assertEquals(5, calculatorService.sum(2, 3));
    }

    @Test
    public void testSumInvalidInput() {
        assertThrows(InvalidInputException.class, () -> calculatorService.sum(0, 3));
    }

    @Test
    public void testSumOverflow() {
        assertThrows(OverflowException.class, () -> calculatorService.sum(Integer.MAX_VALUE, 1));
    }

    @Test
    public void testSumNegativeNumbers() {
        assertEquals(-5, calculatorService.sum(-2, -3));
    }

    @Test
    public void testSumZero() {
        assertThrows(InvalidInputException.class, () -> calculatorService.sum(0, 0));
    }
}