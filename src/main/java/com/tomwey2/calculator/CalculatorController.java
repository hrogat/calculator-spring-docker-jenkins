package com.tomwey2.calculator;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorService calculatorService;

    @RequestMapping("/sum")
    String sum(@RequestParam("a") @NotNull final Integer a, @RequestParam("b") @NotNull final Integer b) {
        return String.valueOf(calculatorService.sum(a, b));
    }

    @RequestMapping("/subtract")
    String subtract(@RequestParam("a") @NotNull final Integer a, @RequestParam("b") @NotNull final Integer b) {
        return String.valueOf(calculatorService.subtract(a, b));
    }

    @RequestMapping("/multiply")
    String multiply(@RequestParam("a") @NotNull final Integer a, @RequestParam("b") @NotNull final Integer b) {
        return String.valueOf(calculatorService.multiply(a, b));
    }

    @RequestMapping("/divide")
    String divide(@RequestParam("a") @NotNull final Integer a, @RequestParam("b") @NotNull final Integer b) {
        return String.valueOf(calculatorService.divide(a, b));
    }

    @RequestMapping("/modulus")
    String modulus(@RequestParam("a") @NotNull final Integer a, @RequestParam("b") @NotNull final Integer b) {
        return String.valueOf(calculatorService.modulus(a, b));
    }

    @RequestMapping("/exponentiate")
    String exponentiate(@RequestParam("base") @NotNull final Integer base, @RequestParam("exponent") @NotNull final Integer exponent) {
        return String.valueOf(calculatorService.exponentiate(base, exponent));
    }
}