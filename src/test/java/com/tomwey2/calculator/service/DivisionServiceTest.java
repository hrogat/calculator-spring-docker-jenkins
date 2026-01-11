package com.tomwey2.calculator.service;

import com.tomwey2.calculator.exception.DivisionByZeroException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DivisionServiceTest {

    private final DivisionService divisionService = new DivisionService();

    @Test
    void divide_ShouldReturnCorrectResult() {
        double result = divisionService.divide(10, 2);
        assertEquals(5, result);
    }

    @Test
    void divide_ByZero_ShouldThrowException() {
        assertThrows(DivisionByZeroException.class, () -> divisionService.divide(10, 0));
    }
}