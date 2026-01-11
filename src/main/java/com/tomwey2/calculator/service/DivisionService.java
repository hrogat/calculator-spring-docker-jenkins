package com.tomwey2.calculator.service;

import com.tomwey2.calculator.exception.DivisionByZeroException;
import org.springframework.stereotype.Service;

@Service
public class DivisionService {

    public double divide(double dividend, double divisor) {
        if (divisor == 0) {
            throw new DivisionByZeroException("Division by zero is not allowed.");
        }
        return dividend / divisor;
    }
}