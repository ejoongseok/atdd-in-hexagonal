package com.example.hexagonal.bank.application.port.out;

import com.example.hexagonal.bank.domain.Amount;

public interface SaveBankPort {
	Amount save(Amount amount);
}
