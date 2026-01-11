package com.tomwey2.calculator.service;

import com.tomwey2.calculator.dto.DivisionRequestDto;
import com.tomwey2.calculator.exception.DivisionByZeroException;
import org.springframework.stereotype.Service;

@Service
public class DivisionService {

    public double divide(DivisionRequestDto request) {
        if (request.getDivisor() == 0) {
            throw new DivisionByZeroException("Division by zero is not allowed.");
        }
        return (double) request.getDividend() / request.getDivisor();
    }
}