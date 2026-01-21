package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void sumTest() throws Exception {
        String requestBody = "{\"a\": 2, \"b\": 3}";
        mockMvc.perform(post("/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5));
    }

    @Test
    public void sumTestWithNullValues() throws Exception {
        String requestBody = "{\"a\": null, \"b\": 3}";
        mockMvc.perform(post("/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void sumTestWithMissingField() throws Exception {
        String requestBody = "{\"a\": 2}";
        mockMvc.perform(post("/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void sumTestWithInvalidJson() throws Exception {
        String requestBody = "{\"a\": 2, \"b\": }";
        mockMvc.perform(post("/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void sumTestWithNonNumericInputs() throws Exception {
        String requestBody = "{\"a\": \"two\", \"b\": 3}";
        mockMvc.perform(post("/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void sumTestWithLargeNumbers() throws Exception {
        String requestBody = "{\"a\": 2147483645, \"b\": 1}";
        mockMvc.perform(post("/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(2147483646));
    }

    @Test
    public void sumTestWithNegativeNumbers() throws Exception {
        String requestBody = "{\"a\": 2, \"b\": -3}";
        mockMvc.perform(post("/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(-1));
    }

    @Test
    public void sumTestWithExtraFields() throws Exception {
        String requestBody = "{\"a\": 2, \"b\": 3, \"c\": 4}";
        mockMvc.perform(post("/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5));
    }
}