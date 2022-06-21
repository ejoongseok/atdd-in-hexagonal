package com.example.hexagonal.bank.adapter.in.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hexagonal.bank.application.dto.DepositRequest;
import com.example.hexagonal.bank.application.dto.DepositResponse;

@RestController
@RequestMapping("/api")
public class BankController {

	@PostMapping("/deposit")
	public DepositResponse deposit(@RequestBody DepositRequest request) {
		DepositResponse depositResponse = new DepositResponse(request.getDepositAmount());
		return depositResponse;
	}

}
