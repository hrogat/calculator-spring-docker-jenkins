package com.tomwey2.calculator;

import com.tomwey2.calculator.dto.SumResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@RestController
@RequestMapping("/api/calculator")
@RequiredArgsConstructor
@Tag(name = "Calculator API", description = "API for performing calculator operations")
public class CalculatorController {
    
    private final CalculatorService calculatorService;

    @Operation(summary = "Add two numbers", description = "Returns the sum of two integers")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully returned sum"),
        @ApiResponse(responseCode = "400", description = "Invalid input parameters")
    })
    @GetMapping("/sum")
    public ResponseEntity<SumResponse> sum(
            @Parameter(description = "First number to add", required = true) 
            @RequestParam("a") Integer a,
            @Parameter(description = "Second number to add", required = true)
            @RequestParam("b") Integer b) {
        
        log.info("Received sum request with parameters: a={}, b={}", a, b);
        
        int result = calculatorService.sum(a, b);
        SumResponse response = new SumResponse(result);
        
        log.debug("Sum calculation successful. Result: {}", result);
        return ResponseEntity.ok(response);
    }
    
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<String> handleMissingParameterException(MissingServletRequestParameterException ex) {
        log.error("Missing required parameter: {}", ex.getParameterName());
        return ResponseEntity.badRequest().body("Missing required parameter: " + ex.getParameterName());
    }
    
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        log.error("Invalid parameter type for parameter '{}': {}", ex.getName(), ex.getValue());
        return ResponseEntity.badRequest().body("Invalid number format");
    }
    
    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<String> handleNumberFormatException(NumberFormatException ex) {
        log.error("Invalid number format: {}", ex.getMessage());
        return ResponseEntity.badRequest().body("Invalid number format");
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        log.error("Unexpected error occurred: {}", ex.getMessage(), ex);
        return ResponseEntity.internalServerError().body("An unexpected error occurred");
    }
}