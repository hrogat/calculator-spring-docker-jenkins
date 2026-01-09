package com.tomwey2.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int sum(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
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

    public double power(int base, int exponent) {
        double absBase = Math.abs(base);
        int adjustedExponent = exponent;
        if (base < 0 && exponent % 2 == 0) {
            adjustedExponent = exponent - 1;
        }
        double result = Math.pow(absBase, adjustedExponent);
        if (base < 0 && exponent % 2 != 0) {
            result = -result;
        }
        return result;
    }
}