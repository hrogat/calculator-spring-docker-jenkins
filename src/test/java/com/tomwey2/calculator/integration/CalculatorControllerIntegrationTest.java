package com.tomwey2.calculator.integration;

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
    void testDivideSuccess() throws Exception {
        mockMvc.perform(get("/divide")
                        .param("a", "10")
                        .param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    void testDivideWithDecimalResult() throws Exception {
        mockMvc.perform(get("/divide")
                        .param("a", "10")
                        .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.3333333333333335"));
    }

    @Test
    void testDivideByZero() throws Exception {
        mockMvc.perform(get("/divide")
                        .param("a", "10")
                        .param("b", "0"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testDivideWithNegativeNumbers() throws Exception {
        mockMvc.perform(get("/divide")
                        .param("a", "-10")
                        .param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("-5.0"));
    }

    @Test
    void testDivideWithBothNegativeNumbers() throws Exception {
        mockMvc.perform(get("/divide")
                        .param("a", "-10")
                        .param("b", "-2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }
}