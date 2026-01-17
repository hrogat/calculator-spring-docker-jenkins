package com.tomwey2.calculator;

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
    public ResponseEntity<SumResponse> sum(@RequestBody SumRequest sumRequest) {
        int result = calculatorService.sum(sumRequest.getA(), sumRequest.getB());
        SumResponse sumResponse = new SumResponse();
        sumResponse.setResult(result);
        return ResponseEntity.ok(sumResponse);
    }
}