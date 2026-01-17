package com.tomwey2.calculator.controller;

import com.tomwey2.calculator.dto.SumRequest;
import com.tomwey2.calculator.dto.SumResponse;
import com.tomwey2.calculator.exception.InvalidInputException;
import com.tomwey2.calculator.exception.OverflowException;
import com.tomwey2.calculator.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorService calculatorService;

    @GetMapping("/sum")
    public ResponseEntity<SumResponse> sum(@RequestBody SumRequest sumRequest) {
        int result = calculatorService.sum(sumRequest.getA(), sumRequest.getB());
        return ResponseEntity.ok(new SumResponse(result));
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<String> handleInvalidInputException(InvalidInputException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(OverflowException.class)
    public ResponseEntity<String> handleOverflowException(OverflowException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}