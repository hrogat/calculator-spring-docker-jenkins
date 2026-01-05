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
    public void subtractEndpointTest() throws Exception {
        mockMvc.perform(get("/subtract").param("a", "5").param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));

        mockMvc.perform(get("/subtract").param("a", "0").param("b", "5"))
                .andExpect(status().isOk())
                .andExpect(content().string("-5"));

        mockMvc.perform(get("/subtract").param("a", "-3").param("b", "-5"))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));
    }
}
