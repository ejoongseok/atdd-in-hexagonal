package com.example.hexagonal.bank.application.port.in;

import com.example.hexagonal.bank.application.dto.DepositAmount;
import com.example.hexagonal.bank.application.dto.DepositRequest;

public interface DepositUseCase {
	DepositAmount deposit(DepositRequest request);
}
