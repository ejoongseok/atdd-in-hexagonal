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
public class Bank {
	private BigDecimal amount;
	private String customer;
	private BigDecimal balance;

	public Bank(String customer) {
		this.customer = customer;
	}

	public void deposit(BigDecimal depositAmount, BigDecimal balance) {
		this.amount = depositAmount;
		this.balance = balance.add(amount);
	}
}
