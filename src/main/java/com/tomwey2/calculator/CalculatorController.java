package com.tomwey2.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/sum")
    public ResponseEntity<SumResponse> sum(@RequestBody SumRequest sumRequest) {
        validateInput(sumRequest.getA(), sumRequest.getB());
        int result = calculatorService.sum(sumRequest.getA(), sumRequest.getB());
        SumResponse sumResponse = new SumResponse();
        sumResponse.setResult(result);
        return ResponseEntity.ok(sumResponse);
    }

    @PostMapping("/subtract")
    public ResponseEntity<SumResponse> subtract(@RequestBody SumRequest sumRequest) {
        validateInput(sumRequest.getA(), sumRequest.getB());
        int result = calculatorService.subtract(sumRequest.getA(), sumRequest.getB());
        SumResponse sumResponse = new SumResponse();
        sumResponse.setResult(result);
        return ResponseEntity.ok(sumResponse);
    }

    @PostMapping("/multiply")
    public ResponseEntity<SumResponse> multiply(@RequestBody SumRequest sumRequest) {
        validateInput(sumRequest.getA(), sumRequest.getB());
        int result = calculatorService.multiply(sumRequest.getA(), sumRequest.getB());
        SumResponse sumResponse = new SumResponse();
        sumResponse.setResult(result);
        return ResponseEntity.ok(sumResponse);
    }

    private void validateInput(int a, int b) {
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            throw new InvalidInputException("Invalid input: Both values are Integer.MIN_VALUE");
        }
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<String> handleInvalidInputException(InvalidInputException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(OverflowException.class)
    public ResponseEntity<String> handleOverflowException(OverflowException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}