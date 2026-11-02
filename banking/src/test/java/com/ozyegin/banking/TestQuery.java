package com.ozyegin.banking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ozyegin.banking.model.BankAccount;
import com.ozyegin.banking.model.Transaction;
import com.ozyegin.banking.service.AccountService;
import com.ozyegin.banking.service.TransactionService;

@SpringBootTest
class TestQuery {
	@Autowired
	AccountService service;
	
	
	@Autowired
	TransactionService trxService;

	@Test
	void testQueryMethods() {
		List<BankAccount> list = service.getAccounts("Taner");
		for (BankAccount bankAccount : list) {
			assertEquals("Taner", bankAccount.getOwner());
		}
		
		List<BankAccount> list2=service.listAccountByNameAndTrxAmount("Taner", 400);
		for (BankAccount bankAccount : list2) {
			assertEquals(10052, bankAccount.getAccountId());
			System.out.println(bankAccount);
		}
	}
	
	@Test
	void testQueryTransactionMethods() {
		List<Transaction> list=trxService.getTransactionsGreaterThan(250);
		assertTrue(list.size()==2);
		for (Transaction transaction : list) {
			assertTrue(transaction.getAmount()>250);
			System.out.println(transaction+" "+transaction.getClass().getSimpleName());
		}
	}
	
	@Test
	void testGetOwnerNames() {
		List<String> names=service.getAccountNames();
		for (String aName : names) {
			System.out.println(aName);
		}
	}

}
