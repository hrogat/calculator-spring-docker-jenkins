package com.tomwey2.calculator.service;

import com.tomwey2.calculator.exception.InvalidInputException;
import com.tomwey2.calculator.exception.OverflowException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CalculatorService {
    public int sum(int a, int b) {
        validateInput(a, b);
        checkOverflow(a, b);
        int result = a + b;
        log.info("Calculated sum: {} + {} = {}", a, b, result);
        return result;
    }

    private void validateInput(int a, int b) {
        if (a == 0 || b == 0) {
            throw new InvalidInputException("Input values cannot be zero.");
        }
    }

    private void checkOverflow(int a, int b) {
        if (a > 0 && b > Integer.MAX_VALUE - a) {
            throw new OverflowException("Sum exceeds maximum integer value.");
        }
        if (a < 0 && b < Integer.MIN_VALUE - a) {
            throw new OverflowException("Sum exceeds minimum integer value.");
        }
    }
}