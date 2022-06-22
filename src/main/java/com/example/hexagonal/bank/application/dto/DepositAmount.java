package com.example.hexagonal.bank.application.dto;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class DepositAmount {
	private Long id;
	private BigDecimal depositAmount;

	public DepositAmount(Long id, BigDecimal depositAmount) {
		this.id = id;
		this.depositAmount = depositAmount;
	}
}
