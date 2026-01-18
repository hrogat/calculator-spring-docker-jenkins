package com.tomwey2.calculator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CalculatorService {

    public int sum(int a, int b) {
        try {
            return Math.addExact(a, b);
        } catch (ArithmeticException e) {
            log.error("Integer overflow occurred while adding {} and {}", a, b);
            throw new IllegalArgumentException("Integer overflow: " + e.getMessage());
        }
    }

    public int subtract(int a, int b) {
        try {
            return Math.subtractExact(a, b);
        } catch (ArithmeticException e) {
            log.error("Integer overflow occurred while subtracting {} and {}", a, b);
            throw new IllegalArgumentException("Integer overflow: " + e.getMessage());
        }
    }

    public int multiply(int a, int b) {
        try {
            return Math.multiplyExact(a, b);
        } catch (ArithmeticException e) {
            log.error("Integer overflow occurred while multiplying {} and {}", a, b);
            throw new IllegalArgumentException("Integer overflow: " + e.getMessage());
        }
    }

    public int divide(int a, int b) {
        if (b == 0) {
            log.error("Division by zero attempted: {} / {}", a, b);
            throw new IllegalArgumentException("Division by zero is not allowed");
        }
        return a / b;
    }
}