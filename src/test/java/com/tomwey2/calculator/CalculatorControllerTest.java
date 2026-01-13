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
    void divideTest() throws Exception {
        mockMvc.perform(get("/divide").param("a", "4").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

    @Test
    void divideByZeroTest() throws Exception {
        mockMvc.perform(get("/divide").param("a", "4").param("b", "0"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void divideNegativeNumbersTest() throws Exception {
        mockMvc.perform(get("/divide").param("a", "-4").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("-2.0"));
    }

    @Test
    void divideDecimalResultTest() throws Exception {
        mockMvc.perform(get("/divide").param("a", "3").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("1.5"));
    }

    @Test
    void divideZeroByNonZeroTest() throws Exception {
        mockMvc.perform(get("/divide").param("a", "0").param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("0.0"));
    }
}
