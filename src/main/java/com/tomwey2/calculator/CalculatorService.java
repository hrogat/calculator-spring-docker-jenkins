package com.tomwey2.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int sum(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return (double) a / b;
    }

    public double power(int a, int b) {
        if (a == 0 && b < 0) {
            throw new ArithmeticException("Zero cannot be raised to a negative power.");
        }
        return Math.pow(a, b);
    }
}