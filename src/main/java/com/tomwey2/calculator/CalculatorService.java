package com.tomwey2.calculator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CalculatorService {
    
    public int sum(int a, int b) {
        log.debug("Calculating sum of {} and {}", a, b);
        int result = a + b;
        log.debug("Sum result: {}", result);
        return result;
    }
}