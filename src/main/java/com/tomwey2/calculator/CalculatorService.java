package com.tomwey2.calculator;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CalculatorService {
    public int sum(int a, int b) {
        return a + b;
    }
    
    // Optional: Wrapper method for reactive consistency
    public Mono<Integer> sumReactive(int a, int b) {
        return Mono.just(a + b);
    }
}