package com.example.hexagonal.bank.application.service;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.hexagonal.bank.application.dto.DepositAmount;
import com.example.hexagonal.bank.application.dto.DepositRequest;

@SpringBootTest
class BankServiceTest {

	@Autowired BankService bankService;


	@Test
	void depositAmountTest() {
		// given
		BigDecimal amount = BigDecimal.valueOf(100);
		DepositRequest request = DepositRequest.of(amount);

		// when
	    DepositAmount depositAmount = bankService.deposit(request);
		// then
		Assertions.assertThat(depositAmount.getId()).isPositive();
		Assertions.assertThat(depositAmount.getDepositAmount()).isEqualByComparingTo(request.getDepositAmount());
	}

}
