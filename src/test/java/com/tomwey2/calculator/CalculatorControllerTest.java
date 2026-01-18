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
    public void sumTest() throws Exception {
        mockMvc.perform(get("/sum").param("a", "2").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    public void subtractTest() throws Exception {
        mockMvc.perform(get("/subtract").param("a", "3").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    public void multiplyTest() throws Exception {
        mockMvc.perform(get("/multiply").param("a", "2").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("6"));
    }

    @Test
    public void divideTest() throws Exception {
        mockMvc.perform(get("/divide").param("a", "4").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

    @Test
    public void divideByZeroTest() throws Exception {
        mockMvc.perform(get("/divide").param("a", "4").param("b", "0"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void modulusTest() throws Exception {
        mockMvc.perform(get("/modulus").param("a", "5").param("b", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
    }

    @Test
    public void modulusByZeroTest() throws Exception {
        mockMvc.perform(get("/modulus").param("a", "5").param("b", "0"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void exponentiateTest() throws Exception {
        mockMvc.perform(get("/exponentiate").param("base", "2").param("exponent", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("8.0"));
    }
}