package com.tomwey2.calculator.controller;

import com.tomwey2.calculator.dto.DivisionRequestDto;
import com.tomwey2.calculator.exception.DivisionByZeroException;
import com.tomwey2.calculator.service.DivisionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

    @ExceptionHandler(DivisionByZeroException.class)
    public ResponseEntity<String> handleDivisionByZeroException(DivisionByZeroException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}