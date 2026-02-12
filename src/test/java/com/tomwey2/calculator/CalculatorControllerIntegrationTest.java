package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testDividePositiveNumbers() throws Exception {
        mockMvc.perform(get("/divide").param("a", "4").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

    @Test
    void testDivideNegativeNumbers() throws Exception {
        mockMvc.perform(get("/divide").param("a", "-4").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("-2.0"));
    }

    @Test
    void testDivideByZero() throws Exception {
        mockMvc.perform(get("/divide").param("a", "4").param("b", "0"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Division by zero is not allowed."));
    }
}