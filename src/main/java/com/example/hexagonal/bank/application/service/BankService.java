package com.example.hexagonal.bank.application.service;

import com.example.hexagonal.bank.application.dto.DepositAmount;
import com.example.hexagonal.bank.application.port.out.SaveBankPort;
import com.example.hexagonal.bank.domain.Amount;
import com.example.hexagonal.bank.application.dto.DepositRequest;
import com.example.hexagonal.bank.application.port.in.DepositUseCase;

public class BankService implements DepositUseCase {

	private final SaveBankPort saveBankPort;

	public BankService(SaveBankPort saveBankPort) {
		this.saveBankPort = saveBankPort;
	}

	@Override
	public DepositAmount deposit(DepositRequest request) {
		Amount amount = new Amount();
		amount.deposit(request.getDepositAmount());
		Amount newAmount = saveBankPort.save(amount);

		DepositAmount depositAmount = new DepositAmount(newAmount.getId(), newAmount.getDepositAmount());
		return depositAmount;
	}
}