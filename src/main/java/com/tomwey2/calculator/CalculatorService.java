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

    /**
     * Calculates a^b (a raised to the power of b).
     * 
     * @param a the base
     * @param b the exponent
     * @return the result of a^b
     * @throws ArithmeticException if a = 0 and b = 0 (undefined)
     */
    public double potentiation(int a, int b) {
        if (a == 0 && b == 0) {
            throw new ArithmeticException("0^0 is undefined.");
        }
        
        if (b == 0) {
            return 1;
        }
        
        if (b < 0) {
            return 1.0 / positivePotentiation(a, -b);
        }
        
        return positivePotentiation(a, b);
    }

    /**
     * Helper method to calculate a^b for positive exponents.
     */
    private double positivePotentiation(int a, int b) {
        double result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }
}