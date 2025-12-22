package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService = new CalculatorService();

    @Test
    public void sumTest() {
        assertEquals(5, calculatorService.sum(2, 3));
        assertEquals(0, calculatorService.sum(0, 0));
        assertEquals(-1, calculatorService.sum(2, -3));
    }

    @Test
    public void multiplyTest() {
        // Basic multiplication
        assertEquals(6, calculatorService.multiply(2, 3));
        assertEquals(0, calculatorService.multiply(0, 5));
        assertEquals(0, calculatorService.multiply(5, 0));
        
        // Multiplication with negative numbers
        assertEquals(-4, calculatorService.multiply(2, -2));
        assertEquals(4, calculatorService.multiply(-2, -2));
        assertEquals(-6, calculatorService.multiply(-2, 3));
        
        // Multiplication with large numbers (edge case for integer overflow)
        assertEquals(2147483647, calculatorService.multiply(2147483647, 1));
        assertEquals(-2147483648, calculatorService.multiply(-2147483648, 1));
        assertEquals(46340 * 46340, calculatorService.multiply(46340, 46340)); // Max safe integer for multiplication
    }
}