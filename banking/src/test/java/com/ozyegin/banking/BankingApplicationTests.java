package com.ozyegin.banking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ozyegin.banking.model.BankAccount;
import com.ozyegin.banking.service.AccountService;

@SpringBootTest
class BankingApplicationTests {
	@Autowired
	AccountService service;
	

	@Test
	void testBankAccount() {
		BankAccount account;
		//account = new BankAccount("Jim", 12345);
		account = new BankAccount("Jim");
		assertNotNull(account);
		assertEquals("Jim", account.getOwner(), "Owner is not assigned");
		assertTrue(account.getBalance()==0);
		account.credit(1000.0);
		assertTrue(account.getBalance()==1000);
		account.debit(50.0);
		assertTrue(account.getBalance()==950);
		assertTrue(account.getAccountId()==0);
		service.addAccount(account);
		assertTrue(account.getAccountId()>0);
	}
	
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before class");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After class");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before method");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After method");
	}

}
