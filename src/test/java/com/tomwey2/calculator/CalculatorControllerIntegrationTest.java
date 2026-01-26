package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    void testDivide() throws Exception {
        // Given
        given(calculatorService.divide(10, 2)).willReturn(5.0);

        // When/Then
        mockMvc.perform(get("/divide")
                        .param("a", "10")
                        .param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    void testDivideByZero() throws Exception {
        // Given
        given(calculatorService.divide(10, 0)).willThrow(new IllegalArgumentException("Cannot divide by zero"));

        // When/Then
        mockMvc.perform(get("/divide")
                        .param("a", "10")
                        .param("b", "0"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Cannot divide by zero"));
    }

    @Test
    void testDivideWithDecimalResult() throws Exception {
        // Given
        given(calculatorService.divide(5, 2)).willReturn(2.5);

        // When/Then
        mockMvc.perform(get("/divide")
                        .param("a", "5")
                        .param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.5"));
    }
}