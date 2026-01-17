package com.tomwey2.calculator;

import com.tomwey2.calculator.exception.InvalidInputException;
import com.tomwey2.calculator.exception.OverflowException;
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
    void testSumWithValidInputs() {
        assertEquals(5, calculatorService.sum(2, 3));
        assertEquals(-1, calculatorService.sum(-2, 1));
        assertEquals(0, calculatorService.sum(0, 0));
    }

    @Test
    void testSumWithNullInputs() {
        assertThrows(InvalidInputException.class, () -> calculatorService.sum(null, 3));
        assertThrows(InvalidInputException.class, () -> calculatorService.sum(2, null));
        assertThrows(InvalidInputException.class, () -> calculatorService.sum(null, null));
    }

    @Test
    void testSumWithOverflow() {
        assertThrows(OverflowException.class, () -> calculatorService.sum(Integer.MAX_VALUE, 1));
        assertThrows(OverflowException.class, () -> calculatorService.sum(Integer.MIN_VALUE, -1));
    }

    @Test
    void testSumWithEdgeCases() {
        assertEquals(Integer.MAX_VALUE, calculatorService.sum(Integer.MAX_VALUE, 0));
        assertEquals(Integer.MIN_VALUE, calculatorService.sum(Integer.MIN_VALUE, 0));
    }
}