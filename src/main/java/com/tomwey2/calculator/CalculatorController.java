package com.tomwey2.calculator;

import com.tomwey2.calculator.dto.CalculationRequest;
import com.tomwey2.calculator.dto.CalculationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
@RequiredArgsConstructor
@Tag(name = "Calculator API", description = "API for performing arithmetic calculations")
public class CalculatorController {
    
    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);
    
    private final CalculatorService calculatorService;

    @PostMapping("/sum")
    @Operation(summary = "Add two numbers", description = "Returns the sum of two integer values")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully calculated sum"),
            @ApiResponse(responseCode = "400", description = "Invalid input parameters"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<CalculationResponse> sum(@Valid @RequestBody CalculationRequest request) {
        logger.info("Received sum request with operands: {} and {}", request.getA(), request.getB());
        
        int result = calculatorService.sum(request.getA(), request.getB());
        
        CalculationResponse response = new CalculationResponse(result);
        logger.info("Successfully calculated sum: {}", result);
        
        return ResponseEntity.ok(response);
    }
}