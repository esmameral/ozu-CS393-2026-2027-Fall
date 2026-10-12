package com.ozyegin.banking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ozyegin.banking.model.BankAccount;
import com.ozyegin.banking.model.ChequeTransaction;
import com.ozyegin.banking.model.DepositTransaction;
import com.ozyegin.banking.model.Transaction;
import com.ozyegin.banking.model.WithdrawalTransaction;
import com.ozyegin.banking.service.AccountService;

@SpringBootTest
class TestTransactions {
	@Autowired
	AccountService service;
	
	@Test
	void testTransactions() {
		BankAccount account;
		account = new BankAccount("Jim", 12345);
		assertNotNull(account);
		
		account.post(new DepositTransaction(1000));
		account.post(new WithdrawalTransaction(200));
		assertTrue(account.getBalance()==800);
		account.post(new ChequeTransaction(100));
		assertEquals(account.getBalance(),699.5);
		service.addAccount();
		
	}
}
