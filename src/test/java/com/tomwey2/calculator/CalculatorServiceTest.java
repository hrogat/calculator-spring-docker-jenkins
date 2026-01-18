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

    @Test
    public void subtract_PositiveNumbers_ReturnsCorrectDifference() {
        assertEquals(1, calculatorService.subtract(3, 2));
    }

    @Test
    public void subtract_NegativeNumbers_ReturnsCorrectDifference() {
        assertEquals(-1, calculatorService.subtract(-3, -2));
    }

    @Test
    public void subtract_MixedNumbers_ReturnsCorrectDifference() {
        assertEquals(5, calculatorService.subtract(3, -2));
    }

    @Test
    public void subtract_ZeroNumbers_ReturnsCorrectDifference() {
        assertEquals(0, calculatorService.subtract(0, 0));
    }

    @Test
    public void subtract_MaxValueNumbers_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.subtract(Integer.MAX_VALUE, Integer.MIN_VALUE);
        });
    }

    @Test
    public void multiply_PositiveNumbers_ReturnsCorrectProduct() {
        assertEquals(6, calculatorService.multiply(2, 3));
    }

    @Test
    public void multiply_NegativeNumbers_ReturnsCorrectProduct() {
        assertEquals(6, calculatorService.multiply(-2, -3));
    }

    @Test
    public void multiply_MixedNumbers_ReturnsCorrectProduct() {
        assertEquals(-6, calculatorService.multiply(2, -3));
    }

    @Test
    public void multiply_ZeroNumbers_ReturnsCorrectProduct() {
        assertEquals(0, calculatorService.multiply(0, 5));
    }

    @Test
    public void multiply_MaxValueNumbers_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.multiply(Integer.MAX_VALUE, 2);
        });
    }

    @Test
    public void divide_PositiveNumbers_ReturnsCorrectQuotient() {
        assertEquals(2, calculatorService.divide(6, 3));
    }

    @Test
    public void divide_NegativeNumbers_ReturnsCorrectQuotient() {
        assertEquals(2, calculatorService.divide(-6, -3));
    }

    @Test
    public void divide_MixedNumbers_ReturnsCorrectQuotient() {
        assertEquals(-2, calculatorService.divide(6, -3));
    }

    @Test
    public void divide_ByZero_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.divide(6, 0);
        });
    }

    @Test
    public void divide_ZeroByNumber_ReturnsZero() {
        assertEquals(0, calculatorService.divide(0, 5));
    }
}