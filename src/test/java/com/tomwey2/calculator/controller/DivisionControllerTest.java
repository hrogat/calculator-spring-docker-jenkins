package com.tomwey2.calculator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomwey2.calculator.dto.DivisionRequestDto;
import com.tomwey2.calculator.exception.DivisionByZeroException;
import com.tomwey2.calculator.service.DivisionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DivisionController.class)
class DivisionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DivisionService divisionService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void divide_ShouldReturnResult() throws Exception {
        DivisionRequestDto request = new DivisionRequestDto();
        request.setDividend(10);
        request.setDivisor(2);

        when(divisionService.divide(anyDouble(), anyDouble())).thenReturn(5.0);

        mockMvc.perform(post("/api/division")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    void divide_ByZero_ShouldReturnBadRequest() throws Exception {
        DivisionRequestDto request = new DivisionRequestDto();
        request.setDividend(10);
        request.setDivisor(0);

        when(divisionService.divide(anyDouble(), anyDouble()))
                .thenThrow(new DivisionByZeroException("Division by zero is not allowed."));

        mockMvc.perform(post("/api/division")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
}