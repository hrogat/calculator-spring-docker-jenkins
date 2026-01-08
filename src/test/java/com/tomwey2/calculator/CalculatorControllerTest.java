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
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSumEndpoint() throws Exception {
        mockMvc.perform(get("/sum").param("a", "2").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    public void testSubtractEndpoint() throws Exception {
        mockMvc.perform(get("/subtract").param("a", "3").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    public void testMultiplyEndpoint() throws Exception {
        mockMvc.perform(get("/multiply").param("a", "2").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("6"));
    }

    @Test
    public void testDivideEndpoint() throws Exception {
        mockMvc.perform(get("/divide").param("a", "4").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

    @Test
    public void testDivideByZeroEndpoint() throws Exception {
        mockMvc.perform(get("/divide").param("a", "5").param("b", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("Error: Division by zero is not allowed."));
    }
}