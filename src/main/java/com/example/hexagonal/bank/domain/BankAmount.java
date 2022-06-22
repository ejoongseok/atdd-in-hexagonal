package com.example.hexagonal.bank.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAmount {
	private Long id;
	private BigDecimal amount;

	private String customer;

	public BankAmount(String customer) {
		this.customer = customer;
	}

	public void deposit(BigDecimal depositAmount) {
		this.amount = depositAmount;
	}
}
