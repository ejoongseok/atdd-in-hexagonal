package com.example.hexagonal.bank.application.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DepositResponse {

	private Long id;
	private BigDecimal depositAmount;

	public DepositResponse(BigDecimal depositAmount) {
		this.depositAmount = depositAmount;
	}
}
