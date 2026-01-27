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
    void testSumWithValidParameters() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", "2")
                        .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    void testSumWithNegativeNumbers() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", "-5")
                        .param("b", "-10"))
                .andExpect(status().isOk())
                .andExpect(content().string("-15"));
    }

    @Test
    void testSumWithZero() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", "0")
                        .param("b", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    void testSumWithMissingParameter() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", "5"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSumWithNonNumericParameter() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", "abc")
                        .param("b", "3"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testSumWithLargeNumbers() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", "1000000")
                        .param("b", "2000000"))
                .andExpect(status().isOk())
                .andExpect(content().string("3000000"));
    }

    @Test
    void testSumWith6And7() throws Exception {
        mockMvc.perform(get("/sum")
                        .param("a", "6")
                        .param("b", "7"))
                .andExpect(status().isOk())
                .andExpect(content().string("13"));
    }
}
