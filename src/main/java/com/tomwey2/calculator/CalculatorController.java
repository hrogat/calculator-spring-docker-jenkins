package com.tomwey2.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping("/sum")
    ResponseEntity<Map<String, Object>> sum(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
        if (a == null || b == null) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid input: parameters cannot be null");
            return ResponseEntity.badRequest().body(errorResponse);
        }
        
        int result = calculatorService.sum(a, b);
        Map<String, Object> response = new HashMap<>();
        response.put("result", result);
        return ResponseEntity.ok(response);
    }
}
