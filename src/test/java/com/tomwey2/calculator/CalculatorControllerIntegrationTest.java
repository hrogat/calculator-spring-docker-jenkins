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
        mockMvc.perform(get("/sum")
                        .param("a", "5")
                        .param("b", "7"))
                .andExpect(status().isOk())
                .andExpect(content().string("12"));
    }

    @Test
    void testSumWithEdgeCase() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", "0")
                        .param("b", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    void testSumWithNegativeInputs() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", "-1")
                        .param("b", "-1"))
                .andExpect(status().isOk())
                .andExpect(content().string("-2"));
    }

    @Test
    void testSumWithPositiveAndNegativeInputs() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", "10")
                        .param("b", "-5"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

}