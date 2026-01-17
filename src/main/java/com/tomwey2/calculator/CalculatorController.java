package com.tomwey2.calculator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequiredArgsConstructor
public class CalculatorController {
    
    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);
    
    private final CalculatorService calculatorService;

    @PostMapping("/sum")
    public ResponseEntity<SumResponse> sum(@RequestBody SumRequest sumRequest) {
        logger.info("Received sum request with a: {} and b: {}", sumRequest.getA(), sumRequest.getB());
        int result = calculatorService.sum(sumRequest.getA(), sumRequest.getB());
        SumResponse sumResponse = new SumResponse();
        sumResponse.setResult(result);
        logger.info("Returning sum response with result: {}", result);
        return ResponseEntity.ok(sumResponse);
    }
}