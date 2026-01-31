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
    void testSumWithPositiveNumbers() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", "5")
                        .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("8"));
    }

    @Test
    void testSumWithNegativeAndPositiveNumbers() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", "-5")
                        .param("b", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    void testSumWithZeros() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", "0")
                        .param("b", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    void testSumWithLargeNumbers() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", "1000000")
                        .param("b", "2000000"))
                .andExpect(status().isOk())
                .andExpect(content().string("3000000"));
    }

    @Test
    void testSumWithMissingParameterA() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("b", "5"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSumWithMissingParameterB() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", "5"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSumWithMissingBothParameters() throws Exception {
        mockMvc.perform(get("/sum"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSumWithNonNumericParameterA() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", "abc")
                        .param("b", "5"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSumWithNonNumericParameterB() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", "5")
                        .param("b", "xyz"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSumWithBothNonNumericParameters() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", "abc")
                        .param("b", "xyz"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSumWithMaxIntegerValue() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", String.valueOf(Integer.MAX_VALUE))
                        .param("b", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(Integer.MAX_VALUE)));
    }

    @Test
    void testSumWithMinIntegerValue() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", String.valueOf(Integer.MIN_VALUE))
                        .param("b", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(Integer.MIN_VALUE)));
    }
}