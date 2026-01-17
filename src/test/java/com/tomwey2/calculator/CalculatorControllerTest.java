package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSum() throws Exception {
        String requestBody = "{\"a\": 2, \"b\": 3}";
        mockMvc.perform(post("/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5));
    }

    @Test
    void testSumNegativeNumbers() throws Exception {
        String requestBody = "{\"a\": -2, \"b\": 1}";
        mockMvc.perform(post("/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(-1));
    }

    @Test
    void testSumLargeNumbers() throws Exception {
        String requestBody = "{\"a\": 2147483645, \"b\": 1}";
        mockMvc.perform(post("/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(2147483646));
    }
}