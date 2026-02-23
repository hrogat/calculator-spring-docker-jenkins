package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add/{a}/{b}")
    String add(@PathVariable int a, @PathVariable int b) {
        return "Result: " + calculatorService.add(a, b);
    }

    @GetMapping("/subtract/{a}/{b}")
    String subtract(@PathVariable int a, @PathVariable int b) {
        return "Result: " + calculatorService.subtract(a, b);
    }

    @GetMapping("/multiply/{a}/{b}")
    String multiply(@PathVariable int a, @PathVariable int b) {
        return "Result: " + calculatorService.multiply(a, b);
    }

    @GetMapping("/divide/{a}/{b}")
    String divide(@PathVariable int a, @PathVariable int b) {
        try {
            return "Result: " + calculatorService.divide(a, b);
        } catch (ArithmeticException e) {
            return "Error: Division by zero";
        }
    }
}