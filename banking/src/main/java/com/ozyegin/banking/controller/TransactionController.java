package com.ozyegin.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozyegin.banking.dto.TransactionSum;
import com.ozyegin.banking.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	TransactionService service;
	
	@GetMapping("/{name}")
	public List<TransactionSum> getAllTransactions(@PathVariable("name") String owner ){
		return service.getTransactionOwnerAndBalance(owner);
	}
	
	@DeleteMapping
	@RequestMapping("/{transactionId}")
	public String deleteTransaction(@PathVariable("transactionId") int id) {
		System.out.println(id);
		return service.deleteTransaction(id);
		
		
	}

}
