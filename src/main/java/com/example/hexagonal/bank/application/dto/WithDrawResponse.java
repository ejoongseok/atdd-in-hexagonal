package com.example.hexagonal.bank.application.dto;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class WithDrawResponse {
	private long id;
	private BigDecimal withDrawAmount;
}
