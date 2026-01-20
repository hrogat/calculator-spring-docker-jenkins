package com.tomwey2.calculator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CalculatorService {
    
    public int sum(int a, int b) {
        log.info("Calculating sum of {} and {}", a, b);
        
        // Basic validation
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Integer overflow: cannot sum two minimum integer values");
        }
        
        int result = a + b;
        
        // Check for overflow
        if (a > 0 && b > 0 && result < 0) {
            throw new IllegalArgumentException("Integer overflow: sum exceeds maximum integer value");
        }
        
        if (a < 0 && b < 0 && result > 0) {
            throw new IllegalArgumentException("Integer overflow: sum exceeds minimum integer value");
        }
        
        log.debug("Sum calculation successful: {} + {} = {}", a, b, result);
        return result;
    }
}