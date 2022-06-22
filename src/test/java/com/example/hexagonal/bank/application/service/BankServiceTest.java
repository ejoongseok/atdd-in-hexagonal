package com.example.hexagonal.bank.application.service;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.hexagonal.bank.adapter.out.persistence.BankPersistenceAdapter;
import com.example.hexagonal.bank.adapter.out.persistence.BankRepository;
import com.example.hexagonal.bank.application.dto.DepositAmount;
import com.example.hexagonal.bank.application.dto.DepositRequest;
import com.example.hexagonal.bank.domain.Amount;

class BankServiceTest {

	BankService bankService;

	@BeforeEach
	void setUp() {
		BankRepository repository = new MemoryBankRepository();
		BankPersistenceAdapter bankPersistenceAdapter = new BankPersistenceAdapter(repository);
		bankService = new BankService(bankPersistenceAdapter);
	}


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

	private static class MemoryBankRepository implements BankRepository {
		AtomicLong atomicLong = new AtomicLong(1);
		@Override
		public Amount save(Amount amount) {
			amount.assignId(nextId());
			return amount;
		}

		private Long nextId() {
			return atomicLong.getAndIncrement();
		}
	}
}
