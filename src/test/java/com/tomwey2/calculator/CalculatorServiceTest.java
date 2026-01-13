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
    public void potentiationTest() {
        assertEquals(8.0, calculatorService.potentiation(2, 3), 0.0001);
        assertEquals(1.0, calculatorService.potentiation(5, 0), 0.0001);
        assertEquals(16.0, calculatorService.potentiation(4, 2), 0.0001);
    }

}