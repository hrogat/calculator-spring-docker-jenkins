package com.tomwey2.calculator;

import com.tomwey2.calculator.dto.SumRequest;
import com.tomwey2.calculator.dto.SumResponse;
import com.tomwey2.calculator.exception.InvalidInputException;
import com.tomwey2.calculator.exception.OverflowException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
@RequiredArgsConstructor
@Slf4j
public class CalculatorController {

    private final CalculatorService calculatorService;

    @PostMapping("/sum")
    public ResponseEntity<SumResponse> sum(@RequestBody SumRequest request) {
        log.info("Received sum request: a={}, b={}", request.getA(), request.getB());
        int result = calculatorService.sum(request.getA(), request.getB());
        SumResponse response = new SumResponse(result);
        log.info("Returning sum response: result={}", result);
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(OverflowException.class)
    public ResponseEntity<String> handleOverflowException(OverflowException ex) {
        log.error("OverflowException: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<String> handleInvalidInputException(InvalidInputException ex) {
        log.error("InvalidInputException: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}