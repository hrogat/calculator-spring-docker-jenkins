package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    public void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    public void sumTest_PositiveNumbers() {
        assertEquals(5, calculatorService.sum(2, 3));
    }

    @Test
    public void sumTest_NegativeNumbers() {
        assertEquals(-5, calculatorService.sum(-2, -3));
        assertEquals(1, calculatorService.sum(-2, 3));
        assertEquals(-1, calculatorService.sum(2, -3));
    }

    @Test
    public void sumTest_WithZero() {
        assertEquals(5, calculatorService.sum(0, 5));
        assertEquals(5, calculatorService.sum(5, 0));
        assertEquals(0, calculatorService.sum(0, 0));
    }

    @Test
    public void sumTest_LargeNumbers() {
        assertEquals(2000000000, calculatorService.sum(1000000000, 1000000000));
        assertEquals(-2000000000, calculatorService.sum(-1000000000, -1000000000));
    }

    @ParameterizedTest
    @CsvSource({
        "2, 3, 5",
        "-2, -3, -5",
        "0, 5, 5",
        "1000000000, 1000000000, 2000000000",
        "-1000000000, -1000000000, -2000000000"
    })
    public void sumTest_Parameterized(int a, int b, int expected) {
        assertEquals(expected, calculatorService.sum(a, b));
    }
}