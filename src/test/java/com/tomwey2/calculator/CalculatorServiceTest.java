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

    @Test
    public void multiply_PositiveNumbers_ReturnsCorrectProduct() {
        assertEquals(6, calculatorService.multiply(2, 3));
    }

    @Test
    public void multiply_NegativeNumbers_ReturnsCorrectProduct() {
        assertEquals(6, calculatorService.multiply(-2, -3));
    }

    @Test
    public void multiply_MixedNumbers_ReturnsCorrectProduct() {
        assertEquals(-6, calculatorService.multiply(-2, 3));
    }

    @Test
    public void multiply_ZeroNumbers_ReturnsCorrectProduct() {
        assertEquals(0, calculatorService.multiply(0, 5));
    }

    @Test
    public void multiply_OneNumber_ReturnsCorrectProduct() {
        assertEquals(5, calculatorService.multiply(1, 5));
    }
}