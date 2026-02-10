package com.tomwey2.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int sum(int a, int b) {
        return a + b;
    }

    /**
     * Divides two integers and returns the result as a double.
     * 
     * @param a the dividend
     * @param b the divisor
     * @return the result of division as a double
     * @throws IllegalArgumentException if the divisor is zero
     */
    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return (double) a / b;
    }
}