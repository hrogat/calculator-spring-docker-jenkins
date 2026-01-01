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

    @Test
    public void divideTest() {
        assertEquals(2.0, calculatorService.divide(4, 2));
        assertEquals(0.5, calculatorService.divide(1, 2));
        assertEquals(-2.0, calculatorService.divide(4, -2));
        assertEquals(2.0, calculatorService.divide(-4, -2));
        assertEquals(0.0, calculatorService.divide(0, 5));
    }

    @Test
    public void divideByZeroTest() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculatorService.divide(5, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    @Test
    public void potentiationTest() {
        // Basic potentiation
        assertEquals(8.0, calculatorService.potentiation(2, 3));
        assertEquals(1.0, calculatorService.potentiation(5, 0));
        assertEquals(0.0, calculatorService.potentiation(0, 5));
        
        // Potentiation with negative exponents
        assertEquals(0.25, calculatorService.potentiation(2, -2));
        assertEquals(-8.0, calculatorService.potentiation(-2, 3));
        
        // Edge case: 0^0 is mathematically undefined, but Math.pow returns 1.0
        assertEquals(1.0, calculatorService.potentiation(0, 0));
    }
}