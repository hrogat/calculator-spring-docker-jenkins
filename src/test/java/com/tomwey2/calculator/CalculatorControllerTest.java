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
    public void potentiationEndpointTest() throws Exception {
        // Test basic potentiation
        mockMvc.perform(get("/potentiation").param("a", "2").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("8.0"));

        // Test potentiation with exponent 0
        mockMvc.perform(get("/potentiation").param("a", "5").param("b", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("1.0"));

        // Test potentiation with negative exponent
        mockMvc.perform(get("/potentiation").param("a", "2").param("b", "-2"))
                .andExpect(status().isOk())
                .andExpect(content().string("0.25"));

        // Test potentiation with base 0
        mockMvc.perform(get("/potentiation").param("a", "0").param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("0.0"));
    }
}
