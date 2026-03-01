package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService = new CalculatorService();

    @Test
    public void sumTest() {
        StepVerifier.create(calculatorService.sum(2, 3))
                .expectNext(5)
                .verifyComplete();
    }

}