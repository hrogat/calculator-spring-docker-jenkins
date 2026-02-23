package com.tomwey2.calculator;

import lombok.RequiredArgsConstructor;
import java.lang.IllegalArgumentException;

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

    // New method for division
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        return a / b;
    }
}