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
class CalculatorApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void testMultiplyEndpoint() throws Exception {
        mockMvc.perform(get("/multiply").param("a", "3").param("b", "4"))
                .andExpect(status().isOk())
                .andExpect(content().string("12"));
    }

    @Test
    void testMultiplyEndpointWithNegativeNumbers() throws Exception {
        mockMvc.perform(get("/multiply").param("a", "-2").param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("-10"));
    }

    @Test
    void testMultiplyEndpointWithZero() throws Exception {
        mockMvc.perform(get("/multiply").param("a", "0").param("b", "100"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }
}