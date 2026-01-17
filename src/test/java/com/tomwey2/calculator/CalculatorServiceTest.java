package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    @Test
    public void sumTest() {
        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.sum(2, 3);
        assertEquals(5, result);
    }
}