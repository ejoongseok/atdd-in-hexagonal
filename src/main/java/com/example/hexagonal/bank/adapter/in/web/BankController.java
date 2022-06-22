package com.example.hexagonal.bank.adapter.in.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hexagonal.bank.application.dto.DepositAmount;
import com.example.hexagonal.bank.application.dto.DepositRequest;
import com.example.hexagonal.bank.application.dto.DepositResponse;
import com.example.hexagonal.bank.application.port.in.DepositUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BankController {

	private final DepositUseCase depositUseCase;

	@PostMapping("/deposit")
	public DepositResponse deposit(@RequestBody DepositRequest request) {
		DepositAmount depositAmount = depositUseCase.deposit(request);
		DepositResponse depositResponse = new DepositResponse(depositAmount);
		return depositResponse;
	}

}
