package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAdd() throws Exception {
        mockMvc.perform(get("/api/calculate/add/2/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5));
    }

    @Test
    public void testSubtract() throws Exception {
        mockMvc.perform(get("/api/calculate/subtract/5/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));
    }

    @Test
    public void testMultiply() throws Exception {
        mockMvc.perform(get("/api/calculate/multiply/2/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("6"));
    }

    @Test
    public void testDivide() throws Exception {
        mockMvc.perform(get("/api/calculate/divide/6/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));
    }

    @Test
    public void testDivideByZero() throws Exception {
        mockMvc.perform(get("/api/calculate/divide/5/0"))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Division by zero is not allowed."));
    }
}