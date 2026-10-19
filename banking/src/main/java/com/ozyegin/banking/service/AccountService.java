package com.ozyegin.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ozyegin.banking.repository.BankAccountRepository;

@Service
@Transactional
public class AccountService {
	@Autowired
	BankAccountRepository repo;
	@Transactional(readOnly = true)
	public void addAccount() {
		System.out.println("I am in the AccountService");
	}


	public void transferMoney(int senderId, int receiverId, double amount) {
		repo.deposit(receiverId, amount);
		repo.withdraw(senderId, amount);
		
	}
	public double getBalance(int accountId) {
		return repo.getBalance(accountId);	
	}
}
