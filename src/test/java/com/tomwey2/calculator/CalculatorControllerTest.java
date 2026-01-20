package com.tomwey2.calculator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomwey2.calculator.dto.MultiplyRequest;
import com.tomwey2.calculator.dto.MultiplyResponse;
import com.tomwey2.calculator.dto.SumRequest;
import com.tomwey2.calculator.dto.SumResponse;
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
    public void sum_ValidInput_ReturnsSumResponse() throws Exception {
        SumRequest request = new SumRequest(2, 3);
        SumResponse expectedResponse = new SumResponse(5);
        
        when(calculatorService.sum(2, 3)).thenReturn(5);

        mockMvc.perform(post("/api/calculator/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5));
    }

    @Test
    public void sum_NullInput_ReturnsBadRequest() throws Exception {
        SumRequest request = new SumRequest(null, 3);

        mockMvc.perform(post("/api/calculator/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.a").value("Value 'a' cannot be null"));
    }

    @Test
    public void sum_MissingInput_ReturnsBadRequest() throws Exception {
        String invalidJson = "{\"a\": 2}";

        mockMvc.perform(post("/api/calculator/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void multiply_ValidInput_ReturnsMultiplyResponse() throws Exception {
        MultiplyRequest request = new MultiplyRequest(2, 3);
        MultiplyResponse expectedResponse = new MultiplyResponse(6);
        
        when(calculatorService.multiply(2, 3)).thenReturn(6);

        mockMvc.perform(post("/api/calculator/multiply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(6));
    }

    @Test
    public void multiply_NullInput_ReturnsBadRequest() throws Exception {
        MultiplyRequest request = new MultiplyRequest(null, 3);

        mockMvc.perform(post("/api/calculator/multiply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors.a").value("Value 'a' cannot be null"));
    }

    @Test
    public void multiply_MissingInput_ReturnsBadRequest() throws Exception {
        String invalidJson = "{\"a\": 2}";

        mockMvc.perform(post("/api/calculator/multiply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidJson))
                .andExpect(status().isBadRequest());
    }
}