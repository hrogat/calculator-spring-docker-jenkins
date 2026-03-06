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
class CalculatorControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDivideEndpoint() throws Exception {
        // Test normal division
        mockMvc.perform(get("/divide").param("a", "6").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.0"));

        // Test division with non-integer result
        mockMvc.perform(get("/divide").param("a", "5").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.5"));
    }

    @Test
    public void testDivideByZero() throws Exception {
        // Test division by zero
        mockMvc.perform(get("/divide").param("a", "5").param("b", "0"))
                .andExpect(status().isBadRequest());
    }
}