package com.example.hexagonal.bank.application.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DepositRequest {

	private BigDecimal depositAmount;
	public DepositRequest(BigDecimal depositAmount) {
		this.depositAmount = depositAmount;
	}

	public static DepositRequest of(BigDecimal depositAmount) {
		return new DepositRequest(depositAmount);
	}
}
