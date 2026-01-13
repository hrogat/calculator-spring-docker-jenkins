package com.tomwey2.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int sum(int a, int b) {
        return a + b;
    }

    public double potentiation(double a, double b) {
        return Math.pow(a, b);
    }
}