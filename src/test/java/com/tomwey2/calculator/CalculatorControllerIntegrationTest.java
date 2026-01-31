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
    void testSumEndpoint() throws Exception {
        // Test valid inputs
        mockMvc.perform(get("/sum")
                        .param("a", "2")
                        .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));

        // Test missing parameter
        mockMvc.perform(get("/sum")
                        .param("a", "2"))
                .andExpect(status().isBadRequest());

        // Test non-numeric parameter
        mockMvc.perform(get("/sum")
                        .param("a", "abc")
                        .param("b", "3"))
                .andExpect(status().isBadRequest());

        // Test negative numbers
        mockMvc.perform(get("/sum")
                        .param("a", "-5")
                        .param("b", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));

        // Test zero values
        mockMvc.perform(get("/sum")
                        .param("a", "0")
                        .param("b", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }
}