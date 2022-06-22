package com.example.hexagonal.bank.application.service;

import org.springframework.stereotype.Service;

import com.example.hexagonal.bank.application.dto.DepositAmount;
import com.example.hexagonal.bank.application.dto.WithDrawAmount;
import com.example.hexagonal.bank.application.dto.WithDrawRequest;
import com.example.hexagonal.bank.application.port.in.WithDrawUseCase;
import com.example.hexagonal.bank.application.port.out.SaveBankPort;
import com.example.hexagonal.bank.domain.BankAmount;
import com.example.hexagonal.bank.application.dto.DepositRequest;
import com.example.hexagonal.bank.application.port.in.DepositUseCase;

@Service
public class BankService implements DepositUseCase, WithDrawUseCase {

	private final SaveBankPort saveBankPort;

	public BankService(SaveBankPort saveBankPort) {
		this.saveBankPort = saveBankPort;
	}

	@Override
	public DepositAmount deposit(DepositRequest request) {
		BankAmount amount = new BankAmount(request.getCustomer());
		amount.deposit(request.getDepositAmount());
		BankAmount newAmount = saveBankPort.save(amount);

		return new DepositAmount(newAmount.getId(), newAmount.getAmount());
	}

	@Override
	public WithDrawAmount withDraw(WithDrawRequest request) {
		return null;
	}
}
