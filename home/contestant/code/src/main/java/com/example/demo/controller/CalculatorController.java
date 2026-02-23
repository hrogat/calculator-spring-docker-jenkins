// src/main/java/com/example/demo/controller/CalculatorController.java
package com.example.demo.controller;

import com.example.demo.dto.CalculatorRequestDTO;
import com.example.demo.dto.CalculatorResponseDTO;
import com.example.demo.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorService calculatorService;

    @PostMapping("/calculate")
    public ResponseEntity<CalculatorResponseDTO> calculate(@RequestBody CalculatorRequestDTO request) {
        try {
            double result = calculatorService.divide(request.getDividend(), request.getDivisor());
            return ResponseEntity.ok(new CalculatorResponseDTO(result));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new CalculatorResponseDTO(e.getMessage()));
        }
    }
}