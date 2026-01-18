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

    /**
     * Endpoint for dividing two numbers.
     * 
     * @param a the dividend
     * @param b the divisor
     * @return the result of a divided by b as a string
     * @throws IllegalArgumentException if b is zero
     */
    @RequestMapping("/divide")
    String divide(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return String.valueOf(calculatorService.divide(a, b));
    }
}