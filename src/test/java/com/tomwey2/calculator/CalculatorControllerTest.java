package com.tomwey2.calculator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomwey2.calculator.dto.SumRequest;
import com.tomwey2.calculator.dto.SumResponse;
import com.tomwey2.calculator.exception.InvalidInputException;
import com.tomwey2.calculator.exception.OverflowException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
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
    void testSumWithValidInputs() throws Exception {
        SumRequest request = new SumRequest(2, 3);
        when(calculatorService.sum(any(), any())).thenReturn(5);

        mockMvc.perform(post("/api/calculator/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5));
    }

    @Test
    void testSumWithNullInputs() throws Exception {
        SumRequest request = new SumRequest(null, 3);
        when(calculatorService.sum(any(), any())).thenThrow(new InvalidInputException("Inputs cannot be null"));

        mockMvc.perform(post("/api/calculator/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSumWithOverflow() throws Exception {
        SumRequest request = new SumRequest(Integer.MAX_VALUE, 1);
        when(calculatorService.sum(any(), any())).thenThrow(new OverflowException("Sum exceeds integer limits"));

        mockMvc.perform(post("/api/calculator/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
}