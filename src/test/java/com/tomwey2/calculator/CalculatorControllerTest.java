package com.tomwey2.calculator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomwey2.calculator.dto.CalculationRequest;
import com.tomwey2.calculator.dto.CalculationResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    void sum_ValidInput_ReturnsCorrectResult() throws Exception {
        // Arrange
        CalculationRequest request = new CalculationRequest(2, 3);
        CalculationResponse expectedResponse = new CalculationResponse(5);
        
        when(calculatorService.sum(2, 3)).thenReturn(5);

        // Act & Assert
        mockMvc.perform(post("/api/calculator/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5));
    }

    @Test
    void sum_InvalidInput_ReturnsBadRequest() throws Exception {
        // Arrange
        CalculationRequest request = new CalculationRequest(null, 3);

        // Act & Assert
        mockMvc.perform(post("/api/calculator/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void sum_MissingInput_ReturnsBadRequest() throws Exception {
        // Arrange
        String invalidJson = "{\"a\": 2}";

        // Act & Assert
        mockMvc.perform(post("/api/calculator/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidJson))
                .andExpect(status().isBadRequest());
    }
}