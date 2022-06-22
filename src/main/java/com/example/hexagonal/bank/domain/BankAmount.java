package com.example.hexagonal.bank.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BankAmount {
	private Long id;
	private BigDecimal amount;

	public BankAmount(Long id, BigDecimal amount) {
		this.id = id;
		this.amount = amount;
	}

	public void deposit(BigDecimal depositAmount) {
		this.amount = depositAmount;
	}
}
