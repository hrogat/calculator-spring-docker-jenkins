package com.example.calculator.service;

import com.example.calculator.dto.DivisionRequestDto;
import com.example.calculator.exception.DivisionByZeroException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DivisionServiceTest {

    private final DivisionService divisionService = new DivisionService();

    @Test
    void testDivide_Success() {
        DivisionRequestDto request = new DivisionRequestDto();
        request.setDividend(10);
        request.setDivisor(2);
        
        double result = divisionService.divide(request);
        assertEquals(5, result);
    }

    @Test
    void testDivide_ByZero_ThrowsException() {
        DivisionRequestDto request = new DivisionRequestDto();
        request.setDividend(10);
        request.setDivisor(0);
        
        assertThrows(DivisionByZeroException.class, () -> divisionService.divide(request));
    }
}