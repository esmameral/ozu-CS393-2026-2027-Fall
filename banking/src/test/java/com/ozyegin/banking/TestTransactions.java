package com.ozyegin.banking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
		account = new BankAccount("Kerem");
		assertNotNull(account);
		
		account.post(new DepositTransaction(1000));
		account.post(new WithdrawalTransaction(200));
		assertTrue(account.getBalance()==800);
		account.post(new ChequeTransaction(100));
		assertEquals(account.getBalance(),699.5);
		service.addAccount(account);	
	}
	
	@Test
	@Transactional
	void testGetData() {
		
		List<BankAccount> list=service.getAll();	
		for (BankAccount bankAccount : list) {
			System.out.println(bankAccount);
			for (Transaction trx : bankAccount.getTransactions()) {
				System.out.println(trx);
			}
			System.out.println();
		}
		
	}
	
	@Test
	void testTransferMoney() {
		int senderId=1;
		int receiverId=2;
		int transferAmount=50;
		
		double senderFirstBalance=service.getBalance(senderId);
		double receiverFirstBalance=service.getBalance(receiverId);
		service.transferMoney(senderId, receiverId, transferAmount);
		double senderLastBalance=service.getBalance(senderId);
		double receiverLastBalance=service.getBalance(receiverId);
		
		assertEquals(senderFirstBalance-transferAmount, senderLastBalance);
		assertEquals(receiverFirstBalance+transferAmount, receiverLastBalance);
	}
}
