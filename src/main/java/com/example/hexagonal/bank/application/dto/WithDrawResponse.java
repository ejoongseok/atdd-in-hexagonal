package com.example.hexagonal.bank.application.dto;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class WithDrawResponse {
	private long id;
	private BigDecimal withDrawAmount;

	public WithDrawResponse(WithDrawAmount withDrawAmount) {
		this.id = withDrawAmount.getId();
		this.withDrawAmount = withDrawAmount.getDepositAmount();
	}
}
