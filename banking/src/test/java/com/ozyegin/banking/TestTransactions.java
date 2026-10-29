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
import com.ozyegin.banking.model.WithdrawalTransaction;
import com.ozyegin.banking.service.AccountService;

@SpringBootTest
class TestTransactions {
	@Autowired
	AccountService service;

	@Test
	void testTransactions() {
		BankAccount account;
		account = new BankAccount("Taner");
		assertNotNull(account);
		DepositTransaction d = new DepositTransaction(1000,"ATM");

		account.post(d);
		
		account.post(new WithdrawalTransaction(200,1));
		assertTrue(account.getBalance() == 800);
		account.post(new ChequeTransaction(200,"A123"));
		assertEquals(account.getBalance(), 599);
		service.addAccount(account);
		assertTrue(account.getAccountId() != 0);
	}

	@Test
	void testTransferMoney() {
		int senderId = 1;
		int receiverId = 2;
		int transferAmount = 50;

		double senderFirstBalance = service.getBalance(senderId);
		double receiverFirstBalance = service.getBalance(receiverId);
		service.transferMoney(senderId, receiverId, transferAmount);
		double senderLastBalance = service.getBalance(senderId);
		double receiverLastBalance = service.getBalance(receiverId);

		assertEquals(senderFirstBalance - transferAmount, senderLastBalance);
		assertEquals(receiverFirstBalance + transferAmount, receiverLastBalance);
	}
}
