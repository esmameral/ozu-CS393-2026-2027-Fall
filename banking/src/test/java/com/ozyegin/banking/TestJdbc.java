package com.ozyegin.banking;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ozyegin.banking.repository.BankAccountDAO;
@SpringBootTest
class TestJdbc {
	@Autowired
	BankAccountDAO repo;

	@Test
	void testWithdraw() {
		double initBalance=repo.getBalance(1);
		repo.withdraw(1, 100);
		double afterBalance=repo.getBalance(1);		
		assertTrue(afterBalance==initBalance-100);		
	}

}
