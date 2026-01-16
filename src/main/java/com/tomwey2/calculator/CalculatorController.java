package com.tomwey2.calculator;

import com.tomwey2.calculator.dto.SubtractionRequest;
import com.tomwey2.calculator.dto.SubtractionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorService calculatorService;

    @PostMapping("/subtract")
    public SubtractionResponse subtract(@RequestBody SubtractionRequest request) {
        int result = calculatorService.subtract(request.getA(), request.getB());
        return new SubtractionResponse(result);
    }
}