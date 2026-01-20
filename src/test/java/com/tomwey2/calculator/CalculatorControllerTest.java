package com.tomwey2.calculator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomwey2.calculator.dto.SumRequest;
import com.tomwey2.calculator.dto.SumResponse;
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

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void sum_ValidRequest_ReturnsCorrectSum() throws Exception {
        SumRequest request = new SumRequest(2, 3);
        SumResponse expectedResponse = new SumResponse(5);

        mockMvc.perform(post("/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5))
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResponse)));
    }

    @Test
    public void sum_NullFirstOperand_ReturnsBadRequest() throws Exception {
        SumRequest request = new SumRequest(null, 3);

        mockMvc.perform(post("/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.a").value("First operand cannot be null"));
    }

    @Test
    public void sum_NullSecondOperand_ReturnsBadRequest() throws Exception {
        SumRequest request = new SumRequest(2, null);

        mockMvc.perform(post("/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.b").value("Second operand cannot be null"));
    }

    @Test
    public void sum_IntegerOverflow_ReturnsBadRequest() throws Exception {
        SumRequest request = new SumRequest(Integer.MAX_VALUE, 1);

        mockMvc.perform(post("/sum")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Integer overflow: sum exceeds maximum integer value"));
    }
}