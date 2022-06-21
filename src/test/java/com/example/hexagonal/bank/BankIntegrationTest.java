package com.example.hexagonal.bank;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class BankIntegrationTest {
	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	MockMvc mockMvc;

	@Test
	void 입금_요청() throws Exception {
		//given
		BigDecimal depositAmount = BigDecimal.valueOf(100);
		DepositRequest request = DepositRequest.of(depositAmount);

		//when
		MockHttpServletResponse response = mockMvc.perform(post("/api/deposit")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(request))
		).andReturn().getResponse();

		//then
		Assertions.assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		DepositResponse depositResponse = objectMapper.readValue(response.getContentAsString(), DepositResponse.class);
		Assertions.assertThat(depositResponse.getDepositAmount()).isEqualByComparingTo(request.getDepositAmount());
		Assertions.assertThat(depositResponse.getId()).isGreaterThan(0);
	}
}