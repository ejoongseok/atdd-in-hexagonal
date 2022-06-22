package com.example.hexagonal.bank.adapter.out.persistence;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BankEntity {
	@Id
	@GeneratedValue
	private Long id;

	private BigDecimal amount;

	private BigDecimal balance;

	private String customer;


	public BankEntity(BigDecimal amount, String customer, BigDecimal balance) {
		this.amount = amount;
		this.customer = customer;
		this.balance = balance;
	}
}
