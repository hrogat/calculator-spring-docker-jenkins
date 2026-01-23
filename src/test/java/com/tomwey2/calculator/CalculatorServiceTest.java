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
    public void divisionTest() {
        assertEquals(2.0, calculatorService.division(4, 2));
        assertEquals(1.5, calculatorService.division(3, 2));
        assertEquals(0.5, calculatorService.division(1, 2));
    }

    @Test
    public void divisionByZeroTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.division(5, 0);
        });
    }
}
