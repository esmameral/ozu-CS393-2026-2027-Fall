package com.ozyegin.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ozyegin.banking.dto.TransactionSum;
import com.ozyegin.banking.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	@Query(value = "Select t from Transaction t where t.amount>?1")
	public List<Transaction> getTransactionsByAmount(double amount);
	
	public List<TransactionSum> findAllByAccountOwner(String name);

}
