package com.tomwey2.calculator.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculationRequest {
    @NotNull(message = "First operand cannot be null")
    private Integer a;
    
    @NotNull(message = "Second operand cannot be null")
    private Integer b;
}