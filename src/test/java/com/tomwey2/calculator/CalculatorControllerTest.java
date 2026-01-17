package com.tomwey2.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @Test
    public void sumTest() throws Exception {
        SumRequest sumRequest = new SumRequest();
        sumRequest.setA(2);
        sumRequest.setB(3);

        when(calculatorService.sum(2, 3)).thenReturn(5);

        mockMvc.perform(post("/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"a\":2,\"b\":3}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5));
    }
}