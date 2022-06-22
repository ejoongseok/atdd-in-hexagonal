package com.example.hexagonal.bank.domain;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class Amount {
	private Long id;
	private BigDecimal depositAmount;

	public void deposit(BigDecimal depositAmount) {
		this.depositAmount = depositAmount;
	}

	public void assignId(Long nextId) {
		this.id = nextId;
	}
}
