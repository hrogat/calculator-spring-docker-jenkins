package com.example.demo.service;

import java.math.BigDecimal;

class CalculatorService {
    private final BigDecimalCalculator calculator;

    public CalculatorService(BigDecimalCalculator calculator) {
        this.calculator = calculator;
    }

    public int add(int a, int b) {
        return calculator.add(a, b);
    }

    public int subtract(int a, int b) {
        return calculator.subtract(a, b);
    }

    public int multiply(int a, int b) {
        return calculator.multiply(a, b);
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return calculator.divide(a, b);
    }
}
