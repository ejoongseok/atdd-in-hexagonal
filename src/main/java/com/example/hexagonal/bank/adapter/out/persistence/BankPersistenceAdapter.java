package com.example.hexagonal.bank.adapter.out.persistence;

import org.springframework.stereotype.Repository;

import com.example.hexagonal.bank.application.port.out.SaveBankPort;
import com.example.hexagonal.bank.domain.BankAmount;

@Repository
public class BankPersistenceAdapter implements SaveBankPort {

	private final BankAmountSpringDataRepository repository;
	private final BankAmountMapper mapper;

	public BankPersistenceAdapter(BankAmountSpringDataRepository repository, BankAmountMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public BankAmount save(BankAmount amount) {
		BankAmountEntity entity = mapper.toEntity(amount);
		BankAmountEntity saveEntity = repository.save(entity);
		return mapper.toDomain(saveEntity);
	}
}
