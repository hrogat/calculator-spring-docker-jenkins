package com.tomwey2.calculator;

import com.tomwey2.calculator.dto.SumRequest;
import com.tomwey2.calculator.dto.SumResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
@RequiredArgsConstructor
public class CalculatorController {
    
    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);
    
    private final CalculatorService calculatorService;

    @Operation(summary = "Add two numbers", description = "Returns the sum of two integers")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully returned sum"),
        @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping("/sum")
    public ResponseEntity<SumResponse> sum(@Valid @RequestBody SumRequest request) {
        logger.info("Received sum request with a={} and b={}", request.getA(), request.getB());
        
        int result = calculatorService.sum(request.getA(), request.getB());
        SumResponse response = new SumResponse(result);
        
        logger.info("Returning sum result: {}", result);
        return ResponseEntity.ok(response);
    }
}