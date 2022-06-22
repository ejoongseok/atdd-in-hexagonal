package com.example.hexagonal.bank.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.example.hexagonal.bank.domain.BankAmount;

@Component
public class BankAmountMapper {

	public BankAmount toDomain(BankAmountEntity entity) {
		return new BankAmount(entity.getId(), entity.getAmount());
	}

	public BankAmountEntity toEntity(BankAmount domain) {
		return new BankAmountEntity(domain.getId(), domain.getAmount());
	}
}
