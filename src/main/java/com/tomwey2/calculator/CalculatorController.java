package com.tomwey2.calculator;

import com.tomwey2.calculator.dto.SumRequest;
import com.tomwey2.calculator.dto.SumResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorService calculatorService;

    @PostMapping("/sum")
    public ResponseEntity<SumResponse> sum(@Valid @RequestBody SumRequest request) {
        int result = calculatorService.sum(request.getA(), request.getB());
        SumResponse response = new SumResponse(result);
        return ResponseEntity.ok(response);
    }
}