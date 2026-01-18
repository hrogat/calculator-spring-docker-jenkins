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
}