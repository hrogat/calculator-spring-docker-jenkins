package com.tomwey2.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping("/sum")
    String sum(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return String.valueOf(calculatorService.sum(a, b));
    }

    @RequestMapping("/subtract")
    String subtract(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return String.valueOf(calculatorService.subtract(a, b));
    }

    @RequestMapping("/potentiate")
    String potentiate(@RequestParam("base") Integer base, @RequestParam("exponent") Integer exponent) {
        return String.valueOf(calculatorService.potentiate(base, exponent));
    }
}
