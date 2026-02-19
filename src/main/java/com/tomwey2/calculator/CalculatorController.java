package com.tomwey2.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Reactive WebFlux controller for calculator operations.
 */
@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/sum")
    Mono<String> sum(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return calculatorService.sum(a, b).map(String::valueOf);
    }
}