package com.example.hexagonal.bank.application.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.example.hexagonal.bank.application.dto.DepositAmount;
import com.example.hexagonal.bank.application.dto.WithDrawAmount;
import com.example.hexagonal.bank.application.dto.WithDrawRequest;
import com.example.hexagonal.bank.application.port.in.WithDrawUseCase;
import com.example.hexagonal.bank.application.port.out.LoadCustomerPort;
import com.example.hexagonal.bank.application.port.out.SaveBankPort;
import com.example.hexagonal.bank.domain.Bank;
import com.example.hexagonal.bank.application.dto.DepositRequest;
import com.example.hexagonal.bank.application.port.in.DepositUseCase;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BankService implements DepositUseCase, WithDrawUseCase {

	private final SaveBankPort saveBankPort;
	private final LoadCustomerPort loadCustomerPort;

	@Override
	public DepositAmount deposit(DepositRequest request) {
		BigDecimal balance = loadCustomerPort.getBalance(request.getCustomer());

		Bank bank = new Bank(request.getCustomer());
		bank.deposit(request.getDepositAmount(), balance);
		Bank newAccount = saveBankPort.save(bank);

		return new DepositAmount(newAccount);
	}

	@Override
	public WithDrawAmount withDraw(WithDrawRequest request) {
		return null;
	}
}
