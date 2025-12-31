package com.tomwey2.calculator;

import com.tomwey2.calculator.dto.PotentiationRequest;
import com.tomwey2.calculator.dto.PotentiationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorService calculatorService;

    @RequestMapping("/sum")
    String sum(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return String.valueOf(calculatorService.sum(a, b));
    }

    @RequestMapping("/multiply")
    String multiply(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        return String.valueOf(calculatorService.multiply(a, b));
    }

    @RequestMapping("/divide")
    String divide(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        try {
            return String.valueOf(calculatorService.divide(a, b));
        } catch (ArithmeticException e) {
            return "Error: " + e.getMessage();
        }
    }

    @PostMapping("/api/potentiation")
    PotentiationResponse potentiation(@RequestBody PotentiationRequest request) {
        try {
            double result = calculatorService.potentiation(request.getA(), request.getB());
            return new PotentiationResponse(result);
        } catch (ArithmeticException e) {
            throw new org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}