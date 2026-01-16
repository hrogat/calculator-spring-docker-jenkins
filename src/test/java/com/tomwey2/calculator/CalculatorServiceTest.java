package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    public void testSum() {
        assertEquals(5, calculatorService.sum(2, 3));
        assertEquals(-1, calculatorService.sum(-2, 1));
        assertEquals(0, calculatorService.sum(0, 0));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, calculatorService.subtract(3, 2));
        assertEquals(-3, calculatorService.subtract(-2, 1));
        assertEquals(0, calculatorService.subtract(0, 0));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculatorService.multiply(2, 3));
        assertEquals(-2, calculatorService.multiply(-2, 1));
        assertEquals(0, calculatorService.multiply(0, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculatorService.divide(6, 3));
        assertEquals(-2, calculatorService.divide(-6, 3));
        assertEquals(0, calculatorService.divide(0, 5));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculatorService.divide(5, 0));
    }
}