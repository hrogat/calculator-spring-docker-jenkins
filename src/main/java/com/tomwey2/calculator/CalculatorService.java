package com.tomwey2.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorService.class);
    
    public int sum(int a, int b) {
        logger.debug("Calculating sum of {} and {}", a, b);
        int result = a + b;
        logger.debug("Sum result: {}", result);
        return result;
    }
}