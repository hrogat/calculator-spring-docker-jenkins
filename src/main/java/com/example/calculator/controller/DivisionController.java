package com.example.calculator.controller;

import com.example.calculator.dto.DivisionRequestDto;
import com.example.calculator.service.DivisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/division")
@RequiredArgsConstructor
public class DivisionController {

    private final DivisionService divisionService;

    @PostMapping
    public ResponseEntity<Double> divide(@RequestBody DivisionRequestDto request) {
        double result = divisionService.divide(request);
        return ResponseEntity.ok(result);
    }
}