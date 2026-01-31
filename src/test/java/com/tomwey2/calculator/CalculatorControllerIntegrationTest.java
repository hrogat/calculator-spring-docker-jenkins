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
    void testSumWithValidInputs() throws Exception {
        // Test basic addition
        mockMvc.perform(get("/sum")
                        .param("a", "5")
                        .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("8"));

        // Test with negative numbers
        mockMvc.perform(get("/sum")
                        .param("a", "-5")
                        .param("b", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));

        // Test with zero
        mockMvc.perform(get("/sum")
                        .param("a", "0")
                        .param("b", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));

        // Test with large numbers
        mockMvc.perform(get("/sum")
                        .param("a", "1000000")
                        .param("b", "2000000"))
                .andExpect(status().isOk())
                .andExpect(content().string("3000000"));
    }

    @Test
    void testSumWithMissingParameters() throws Exception {
        // Test missing parameter a
        mockMvc.perform(get("/sum")
                        .param("b", "5"))
                .andExpect(status().isBadRequest());

        // Test missing parameter b
        mockMvc.perform(get("/sum")
                        .param("a", "5"))
                .andExpect(status().isBadRequest());

        // Test missing both parameters
        mockMvc.perform(get("/sum"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSumWithInvalidParameters() throws Exception {
        // Test non-numeric parameter a
        mockMvc.perform(get("/sum")
                        .param("a", "abc")
                        .param("b", "5"))
                .andExpect(status().isBadRequest());

        // Test non-numeric parameter b
        mockMvc.perform(get("/sum")
                        .param("a", "5")
                        .param("b", "xyz"))
                .andExpect(status().isBadRequest());

        // Test both non-numeric parameters
        mockMvc.perform(get("/sum")
                        .param("a", "abc")
                        .param("b", "xyz"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSumWithEdgeCases() throws Exception {
        // Test maximum integer values
        mockMvc.perform(get("/sum")
                        .param("a", String.valueOf(Integer.MAX_VALUE))
                        .param("b", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(Integer.MAX_VALUE)));

        // Test minimum integer values
        mockMvc.perform(get("/sum")
                        .param("a", String.valueOf(Integer.MIN_VALUE))
                        .param("b", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(Integer.MIN_VALUE)));
    }
}