package com.tomwey2.calculator;

import com.tomwey2.calculator.exception.InvalidInputException;
import com.tomwey2.calculator.exception.OverflowException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CalculatorService {

    public int sum(Integer a, Integer b) {
        if (a == null || b == null) {
            log.error("Invalid input: null values provided");
            throw new InvalidInputException("Inputs cannot be null");
        }

        long result = (long) a + b;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            log.error("Overflow detected: a={}, b={}", a, b);
            throw new OverflowException("Sum exceeds integer limits");
        }

        log.info("Successfully computed sum: a={}, b={}, result={}", a, b, result);
        return (int) result;
    }
}