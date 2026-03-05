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
    public void divideEndpointTest() throws Exception {
        mockMvc.perform(get("/divide").param("a", "6").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.0"));

        mockMvc.perform(get("/divide").param("a", "5").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.5"));
    }

    @Test
    public void divideByZeroEndpointTest() throws Exception {
        mockMvc.perform(get("/divide").param("a", "5").param("b", "0"))
                .andExpect(status().isBadRequest());
    }
}