package com.tomwey2.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int sum(int a, int b) {
        return a + b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            return Double.POSITIVE_INFINITY;
        }
        return (double) a / b;
    }
}
