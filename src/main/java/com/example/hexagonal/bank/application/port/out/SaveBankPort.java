package com.example.hexagonal.bank.application.port.out;

import com.example.hexagonal.bank.domain.BankAmount;

public interface SaveBankPort {
	BankAmount save(BankAmount amount);
}
