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

    public double potentiation(int a, int b) {
        if (a == 0 && b == 0) {
            throw new ArithmeticException("0^0 is mathematically undefined.");
        }
        if (b < 0) {
            return 1.0 / potentiationPositive(a, -b);
        }
        return potentiationPositive(a, b);
    }

    private int potentiationPositive(int a, int b) {
        if (b == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }
}