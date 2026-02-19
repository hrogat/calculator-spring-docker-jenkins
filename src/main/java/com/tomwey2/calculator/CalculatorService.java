package com.tomwey2.calculator;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CalculatorService {
    public Mono<Integer> sum(int a, int b) {
        return Mono.just(a + b);
    }
}