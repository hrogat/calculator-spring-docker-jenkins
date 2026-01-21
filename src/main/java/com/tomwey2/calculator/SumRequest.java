package com.tomwey2.calculator;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SumRequest {
    @NotNull(message = "Value 'a' cannot be null")
    private Integer a;
    
    @NotNull(message = "Value 'b' cannot be null")
    private Integer b;
}