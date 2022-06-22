package com.example.hexagonal.bank.adapter.out.persistence;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BankAmountEntity {
	@Id
	@GeneratedValue
	private Long id;

	private BigDecimal amount;

	public BankAmountEntity(Long id, BigDecimal amount) {
		this.id = id;
		this.amount = amount;
	}
}
