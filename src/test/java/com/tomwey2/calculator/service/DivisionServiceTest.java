package com.tomwey2.calculator.service;

import com.tomwey2.calculator.exception.DivisionByZeroException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DivisionServiceTest {

    @InjectMocks
    private DivisionService divisionService;

    @Test
    void divide_validInput_returnsCorrectResult() {
        double dividend = 10.0;
        double divisor = 2.0;
        double expected = 5.0;

        double result = divisionService.divide(dividend, divisor);

        assertEquals(expected, result);
    }

    @Test
    void divide_divisorIsZero_throwsDivisionByZeroException() {
        double dividend = 10.0;
        double divisor = 0.0;

        assertThrows(DivisionByZeroException.class, () -> {
            divisionService.divide(dividend, divisor);
        });
    }
}