package com.ozyegin.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ozyegin.banking.dto.TransactionSum;
import com.ozyegin.banking.model.Transaction;
import com.ozyegin.banking.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	TransactionRepository repo;
	
	public List<Transaction> getTransactionsGreaterThan(double amount){
		return repo.getTransactionsByAmount(amount);
		
	}
	
	public List<TransactionSum> getTransactionOwnerAndBalance(String name){
		return repo.findAllByAccountOwner(name);
	}
	
	public String deleteTransaction(int id) {
		System.out.println(id);
		repo.deleteById(id);
		return "success";
	}

}
