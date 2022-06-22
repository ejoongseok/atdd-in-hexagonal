package com.example.hexagonal.bank.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAmountSpringDataRepository extends JpaRepository<BankAmountEntity, Long> {
}
