package com.tomwey2.calculator.integration;

import com.tomwey2.calculator.CalculatorApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = CalculatorApplication.class)
@AutoConfigureMockMvc
class CalculatorControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testDivideEndpointWithValidInput() throws Exception {
        mockMvc.perform(get("/divide")
                        .param("a", "10")
                        .param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    void testDivideEndpointWithDecimalResult() throws Exception {
        mockMvc.perform(get("/divide")
                        .param("a", "10")
                        .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.3333333333333335"));
    }

    @Test
    void testDivideEndpointWithNegativeNumbers() throws Exception {
        mockMvc.perform(get("/divide")
                        .param("a", "-10")
                        .param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("-5.0"));
    }

    @Test
    void testDivideEndpointWithDivisionByZero() throws Exception {
        mockMvc.perform(get("/divide")
                        .param("a", "10")
                        .param("b", "0"))
                .andExpect(status().isBadRequest());
    }
}