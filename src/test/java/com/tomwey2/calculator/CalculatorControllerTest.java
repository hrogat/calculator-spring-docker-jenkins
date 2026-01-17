package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSum() throws Exception {
        String requestBody = "{\"a\": 5, \"b\": 3}";
        mockMvc.perform(post("/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(8));
    }

    @Test
    public void testSubtract() throws Exception {
        String requestBody = "{\"a\": 5, \"b\": 3}";
        mockMvc.perform(post("/subtract")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(2));
    }

    @Test
    public void testMultiply() throws Exception {
        String requestBody = "{\"a\": 5, \"b\": 3}";
        mockMvc.perform(post("/multiply")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(15));
    }

    @Test
    public void testSumWithInvalidInput() throws Exception {
        String requestBody = "{\"a\": -2147483648, \"b\": -2147483648}";
        mockMvc.perform(post("/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testSumWithOverflow() throws Exception {
        String requestBody = "{\"a\": 2147483647, \"b\": 1}";
        mockMvc.perform(post("/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isBadRequest());
    }
}