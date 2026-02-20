package com.tomwey2.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/sum")
    Mono<String> sum(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return Mono.fromCallable(() -> String.valueOf(calculatorService.sum(a, b)));
    }
}