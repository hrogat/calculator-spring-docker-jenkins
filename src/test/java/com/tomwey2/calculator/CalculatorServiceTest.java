package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {

    @InjectMocks
    private CalculatorService calculatorService;

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
        assertEquals(1, calculatorService.sum(5, -4));
    }

    @Test
    public void sum_ZeroNumbers_ReturnsCorrectSum() {
        assertEquals(0, calculatorService.sum(0, 0));
    }

    @Test
    public void sum_MaxIntegerPlusOne_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.sum(Integer.MAX_VALUE, 1);
        });
        assertEquals("Integer overflow: sum exceeds maximum integer value", exception.getMessage());
    }

    @Test
    public void sum_MinIntegerPlusMinInteger_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.sum(Integer.MIN_VALUE, Integer.MIN_VALUE);
        });
        assertEquals("Integer overflow: cannot sum two minimum integer values", exception.getMessage());
    }

    @Test
    public void sum_MinIntegerPlusNegativeOne_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.sum(Integer.MIN_VALUE, -1);
        });
        assertEquals("Integer overflow: sum exceeds minimum integer value", exception.getMessage());
    }
}