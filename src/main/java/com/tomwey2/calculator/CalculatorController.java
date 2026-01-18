package com.tomwey2.calculator;

import com.tomwey2.calculator.dto.CalculationRequest;
import com.tomwey2.calculator.dto.CalculationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/calculator")
@RequiredArgsConstructor
@Tag(name = "Calculator API", description = "API for basic arithmetic operations")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @PostMapping("/sum")
    @Operation(summary = "Add two integers", description = "Returns the sum of two integer values")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid input or integer overflow")
    })
    public ResponseEntity<CalculationResponse> sum(@Valid @RequestBody CalculationRequest request) {
        log.info("Received sum request with operands: {} and {}", request.getA(), request.getB());
        int result = calculatorService.sum(request.getA(), request.getB());
        CalculationResponse response = new CalculationResponse(result);
        log.info("Sum operation completed successfully. Result: {}", result);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/subtract")
    @Operation(summary = "Subtract two integers", description = "Returns the difference between two integer values")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid input or integer overflow")
    })
    public ResponseEntity<CalculationResponse> subtract(@Valid @RequestBody CalculationRequest request) {
        log.info("Received subtract request with operands: {} and {}", request.getA(), request.getB());
        int result = calculatorService.subtract(request.getA(), request.getB());
        CalculationResponse response = new CalculationResponse(result);
        log.info("Subtract operation completed successfully. Result: {}", result);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/multiply")
    @Operation(summary = "Multiply two integers", description = "Returns the product of two integer values")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid input or integer overflow")
    })
    public ResponseEntity<CalculationResponse> multiply(@Valid @RequestBody CalculationRequest request) {
        log.info("Received multiply request with operands: {} and {}", request.getA(), request.getB());
        int result = calculatorService.multiply(request.getA(), request.getB());
        CalculationResponse response = new CalculationResponse(result);
        log.info("Multiply operation completed successfully. Result: {}", result);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/divide")
    @Operation(summary = "Divide two integers", description = "Returns the quotient of two integer values")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "400", description = "Invalid input, division by zero, or integer overflow")
    })
    public ResponseEntity<CalculationResponse> divide(@Valid @RequestBody CalculationRequest request) {
        log.info("Received divide request with operands: {} and {}", request.getA(), request.getB());
        int result = calculatorService.divide(request.getA(), request.getB());
        CalculationResponse response = new CalculationResponse(result);
        log.info("Divide operation completed successfully. Result: {}", result);
        return ResponseEntity.ok(response);
    }
}