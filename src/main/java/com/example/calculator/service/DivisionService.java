package com.example.calculator.service;

import com.example.calculator.dto.DivisionRequestDto;
import com.example.calculator.exception.DivisionByZeroException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DivisionService {

    public double divide(DivisionRequestDto request) {
        if (request.getDivisor() == 0) {
            throw new DivisionByZeroException("Division by zero is not allowed.");
        }
        return request.getDividend() / request.getDivisor();
    }
}