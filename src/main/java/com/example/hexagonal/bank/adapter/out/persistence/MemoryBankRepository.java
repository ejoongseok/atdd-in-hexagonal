package com.example.hexagonal.bank.adapter.out.persistence;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.example.hexagonal.bank.domain.Amount;

@Repository
public class MemoryBankRepository implements BankRepository {
	AtomicLong atomicLong = new AtomicLong(1);

	@Override
	public Amount save(Amount amount) {
		amount.assignId(nextId());
		return amount;
	}

	private Long nextId() {
		return atomicLong.getAndIncrement();
	}
}
