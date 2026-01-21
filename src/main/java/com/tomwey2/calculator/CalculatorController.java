package com.tomwey2.calculator;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/sum")
    public ResponseEntity<SumResponse> sum(@Valid @RequestBody SumRequest request) {
        int result = calculatorService.sum(request.getA(), request.getB());
        SumResponse response = new SumResponse();
        response.setResult(result);
        return ResponseEntity.ok(response);
    }
}