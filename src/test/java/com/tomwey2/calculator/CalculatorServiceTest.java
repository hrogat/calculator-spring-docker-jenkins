package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService = new CalculatorService();

    @Test
    public void sum_PositiveNumbers_ReturnsCorrectSum() {
        assertEquals(5, calculatorService.sum(2, 3));
    }

    @Test
    public void sum_NegativeNumbers_ReturnsCorrectSum() {
        assertEquals(-5, calculatorService.sum(-2, -3));
    }

    @Test
    public void sum_MixedNumbers_ReturnsCorrectSum() {
        assertEquals(0, calculatorService.sum(-2, 2));
    }

    @Test
    public void sum_ZeroNumbers_ReturnsCorrectSum() {
        assertEquals(0, calculatorService.sum(0, 0));
    }
}