package com.example.hexagonal.bank.application.dto;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class WithDrawAmount {
	private Long id;
	private BigDecimal depositAmount;
}
