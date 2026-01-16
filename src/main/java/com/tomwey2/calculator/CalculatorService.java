package com.tomwey2.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);

    public int sum(int a, int b) {
        logger.debug("Calculating sum of {} and {}", a, b);
        return a + b;
    }

    public int subtract(int a, int b) {
        logger.debug("Calculating subtraction of {} from {}", b, a);
        return a - b;
    }

    public int multiply(int a, int b) {
        logger.debug("Calculating multiplication of {} and {}", a, b);
        return a * b;
    }

    public int divide(int a, int b) {
        logger.debug("Calculating division of {} by {}", a, b);
        if (b == 0) {
            logger.error("Attempted division by zero");
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}