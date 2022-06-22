package com.example.hexagonal.bank.adapter.out.persistence;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

	private String customer;


	public BankAmountEntity(Long id, BigDecimal amount, String customer) {
		this.id = id;
		this.amount = amount;
		this.customer = customer;
	}

}
