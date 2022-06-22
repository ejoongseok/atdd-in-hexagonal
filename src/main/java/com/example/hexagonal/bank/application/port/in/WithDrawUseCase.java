package com.example.hexagonal.bank.application.port.in;

import com.example.hexagonal.bank.application.dto.WithDrawAmount;
import com.example.hexagonal.bank.application.dto.WithDrawRequest;

public interface WithDrawUseCase {
	WithDrawAmount withDraw(WithDrawRequest request);
}
