package com.example.hexagonal.bank.application.dto;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class WithDrawRequest {
	private BigDecimal withDrawAmount;

	public WithDrawRequest(BigDecimal withDrawAmount) {
		this.withDrawAmount = withDrawAmount;
	}

	public static WithDrawRequest of(BigDecimal withDrawAmount) {
		return new WithDrawRequest(withDrawAmount);
	}
}
