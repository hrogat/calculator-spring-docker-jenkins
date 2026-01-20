package com.tomwey2.calculator.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MultiplyRequest {
    @NotNull(message = "Value 'a' cannot be null")
    private Integer a;
    
    @NotNull(message = "Value 'b' cannot be null")
    private Integer b;
}