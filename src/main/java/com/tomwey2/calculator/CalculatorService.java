package com.tomwey2.calculator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculatorService {
    
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    // Add divide method with proper error handling
    public double divide(double dividend, double divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return dividend / divisor;
    }
}