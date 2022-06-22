package com.example.hexagonal.bank.adapter.out.persistence;

import com.example.hexagonal.bank.domain.Amount;

public interface BankRepository {
	Amount save(Amount entity);
}
