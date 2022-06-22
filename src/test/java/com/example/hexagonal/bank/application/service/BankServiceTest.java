package com.example.hexagonal.bank.application.service;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.hexagonal.bank.application.web.DepositAmount;
import com.example.hexagonal.bank.application.web.DepositRequest;
import com.example.hexagonal.bank.application.web.WithDrawAmount;
import com.example.hexagonal.bank.application.web.WithDrawRequest;

@SpringBootTest
class BankServiceTest {

	@Autowired BankService bankService;


	@Test
	void depositAmountTest() {
		// given
		BigDecimal amount = BigDecimal.valueOf(100);
		String customer = "joongseok";
		DepositRequest request = DepositRequest.of(amount, customer);

		// when
	    DepositAmount depositAmount = bankService.deposit(request);
		// then
		Assertions.assertThat(depositAmount.getDepositAmount()).isEqualByComparingTo(request.getDepositAmount());
		Assertions.assertThat(depositAmount.getCustomer()).isEqualTo(customer);
		Assertions.assertThat(depositAmount.getBalance()).isEqualByComparingTo(amount);
	}

	@Test
	void withdrawAmountTest() {
		// given
		BigDecimal amount = BigDecimal.valueOf(100);
		String customer = "joongseok";
		DepositRequest request = DepositRequest.of(amount, customer);

		// when
	    DepositAmount depositAmount = bankService.deposit(request);

		// then
		Assertions.assertThat(depositAmount.getDepositAmount()).isEqualByComparingTo(request.getDepositAmount());
		Assertions.assertThat(depositAmount.getCustomer()).isEqualTo(customer);
		Assertions.assertThat(depositAmount.getBalance()).isEqualByComparingTo(amount);


		BigDecimal withdrawAmountDecimal = BigDecimal.valueOf(60);
		WithDrawRequest withDrawRequest = WithDrawRequest.of(withdrawAmountDecimal, customer);

		WithDrawAmount withDrawAmount = bankService.withDraw(withDrawRequest);

		Assertions.assertThat(withDrawAmount.getWithDrawAmount()).isEqualByComparingTo(withDrawRequest.getWithDrawAmount());
		Assertions.assertThat(withDrawAmount.getCustomer()).isEqualTo(customer);
		Assertions.assertThat(withDrawAmount.getBalance()).isEqualByComparingTo(new BigDecimal(40));
	}

	@Test
	void shouldWithDrawGreaterThanAmountReturnThrow() {
		// given
		BigDecimal withdrawAmountDecimal = BigDecimal.valueOf(60);
		String customer = "joongseok";
		WithDrawRequest withDrawRequest = WithDrawRequest.of(withdrawAmountDecimal, customer);

		// when
		Assertions.assertThatThrownBy(() -> bankService.withDraw(withDrawRequest))
			.isInstanceOf(IllegalArgumentException.class);

		// then
	}


}
