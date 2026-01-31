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
    public void divideTestWithEvenDivision() {
        assertEquals(2.0, calculatorService.divide(4, 2));
    }

    @Test
    public void divideTestWithDecimalResult() {
        assertEquals(3.3333333333333335, calculatorService.divide(10, 3));
    }

    @Test
    public void divideTestWithSmallNumbers() {
        assertEquals(0.5, calculatorService.divide(1, 2));
    }

    @Test
    public void divideByZeroTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.divide(5, 0);
        });
    }
}