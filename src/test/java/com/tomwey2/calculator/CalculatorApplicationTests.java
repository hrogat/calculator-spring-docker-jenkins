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
class CalculatorApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void testDivideEndpoint() throws Exception {
		mockMvc.perform(get("/divide").param("a", "10").param("b", "2"))
				.andExpect(status().isOk())
				.andExpect(content().string("5.0"));
	}

	@Test
	void testDivideByZeroEndpoint() throws Exception {
		mockMvc.perform(get("/divide").param("a", "10").param("b", "0"))
				.andExpect(status().isBadRequest());
	}

	@Test
	void testDivideDecimalResult() throws Exception {
		mockMvc.perform(get("/divide").param("a", "5").param("b", "2"))
				.andExpect(status().isOk())
				.andExpect(content().string("2.5"));
	}
}
