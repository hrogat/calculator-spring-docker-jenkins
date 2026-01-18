package com.tomwey2.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int sum(int a, int b) {
        return a + b;
    }

    /**
     * Divides two numbers and returns the result as a double.
     * 
     * @param a the dividend
     * @param b the divisor
     * @return the result of a divided by b
     * @throws IllegalArgumentException if b is zero (division by zero)
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return (double) a / b;
    }
}