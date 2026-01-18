package com.tomwey2.calculator;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping("/sum")
    String sum(@RequestParam("a") @NotNull Integer a, @RequestParam("b") @NotNull Integer b) {
        return String.valueOf(calculatorService.sum(a, b));
    }

    @RequestMapping("/subtract")
    String subtract(@RequestParam("a") @NotNull Integer a, @RequestParam("b") @NotNull Integer b) {
        return String.valueOf(calculatorService.subtract(a, b));
    }

    @RequestMapping("/multiply")
    String multiply(@RequestParam("a") @NotNull Integer a, @RequestParam("b") @NotNull Integer b) {
        return String.valueOf(calculatorService.multiply(a, b));
    }

    @RequestMapping("/divide")
    String divide(@RequestParam("a") @NotNull Integer a, @RequestParam("b") @NotNull Integer b) {
        return String.valueOf(calculatorService.divide(a, b));
    }
}