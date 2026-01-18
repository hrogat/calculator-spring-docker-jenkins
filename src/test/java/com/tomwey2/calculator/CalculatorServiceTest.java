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
    public void multiplyTest() {
        assertEquals(6, calculatorService.multiply(2, 3));
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
    public void modulusTest() {
        assertEquals(1, calculatorService.modulus(5, 2));
    }

    @Test
    public void modulusByZeroTest() {
        assertThrows(IllegalArgumentException.class, () -> calculatorService.modulus(5, 0));
    }

    @Test
    public void exponentiateTest() {
        assertEquals(8.0, calculatorService.exponentiate(2, 3));
    }
}