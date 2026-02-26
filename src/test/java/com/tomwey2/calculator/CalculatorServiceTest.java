package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void sumTest() {
        Mono<Integer> result = calculatorService.sum(2, 3);
        StepVerifier.create(result)
                .expectNext(5)
                .verifyComplete();
    }
}