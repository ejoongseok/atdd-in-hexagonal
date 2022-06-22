package com.example.hexagonal.bank.adapter.out.persistence;

import com.example.hexagonal.bank.application.port.out.SaveBankPort;
import com.example.hexagonal.bank.domain.Amount;

public class BankPersistenceAdapter implements SaveBankPort {

	private final BankRepository repository;

	public BankPersistenceAdapter(BankRepository repository) {
		this.repository = repository;
	}

	@Override
	public Amount save(Amount amount) {
		Amount newAmount = repository.save(amount);

		return newAmount;
	}
}
