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
        assertEquals(0, calculatorService.sum(-2, 2));
    }

    @Test
    public void sum_ZeroNumbers_ReturnsCorrectSum() {
        assertEquals(0, calculatorService.sum(0, 0));
    }

    @Test
    public void sum_MaxValueNumbers_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.sum(Integer.MAX_VALUE, Integer.MAX_VALUE);
        });
    }

    @Test
    public void sum_MinValueNumbers_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.sum(Integer.MIN_VALUE, Integer.MIN_VALUE);
        });
    }
}