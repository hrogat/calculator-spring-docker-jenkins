package com.tomwey2.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculate")
public class CalculatorController {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/add/{a}/{b}")
    public ResponseEntity<SumResponse> add(@PathVariable int a, @PathVariable int b) {
        logger.info("Received request to add {} and {}", a, b);
        int result = calculatorService.sum(a, b);
        SumResponse response = new SumResponse();
        response.setResult(result);
        logger.info("Returning result: {}", result);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/subtract/{a}/{b}")
    public ResponseEntity<String> subtract(@PathVariable int a, @PathVariable int b) {
        logger.info("Received request to subtract {} from {}", b, a);
        int result = calculatorService.subtract(a, b);
        logger.info("Returning result: {}", result);
        return ResponseEntity.ok(String.valueOf(result));
    }

    @GetMapping("/multiply/{a}/{b}")
    public ResponseEntity<String> multiply(@PathVariable int a, @PathVariable int b) {
        logger.info("Received request to multiply {} and {}", a, b);
        int result = calculatorService.multiply(a, b);
        logger.info("Returning result: {}", result);
        return ResponseEntity.ok(String.valueOf(result));
    }

    @GetMapping("/divide/{a}/{b}")
    public ResponseEntity<String> divide(@PathVariable int a, @PathVariable int b) {
        logger.info("Received request to divide {} by {}", a, b);
        try {
            int result = calculatorService.divide(a, b);
            logger.info("Returning result: {}", result);
            return ResponseEntity.ok(String.valueOf(result));
        } catch (ArithmeticException e) {
            logger.error("Division by zero error: {}", e.getMessage());
            return ResponseEntity.internalServerError().body("Division by zero is not allowed.");
        }
    }
}