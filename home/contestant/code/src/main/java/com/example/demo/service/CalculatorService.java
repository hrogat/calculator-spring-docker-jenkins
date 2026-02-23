// src/main/java/com/example/demo/service/CalculatorService.java
package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalculatorService {
    
    public double divide(double dividend, double divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        return dividend / divisor;
    }
}