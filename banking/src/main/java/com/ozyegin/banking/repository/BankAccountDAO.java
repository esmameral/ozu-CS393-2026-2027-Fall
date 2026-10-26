package com.ozyegin.banking.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BankAccountDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void withdraw(int accountId, double amount) {
		String sql="UPDATE ACCOUNT SET BALANCE=BALANCE-? WHERE ID=?";
		jdbcTemplate.update(sql,amount, accountId);
	}
	
	public void deposit(int accountId, double amount) {
		String sql="UPDATE ACCOUNT SET BALANCE=BALANCE+? WHERE ID=?";
		jdbcTemplate.update(sql,amount, accountId);
	}
	
	public double getBalance(int accountId) {
		String sql="SELECT BALANCE FROM ACCOUNT WHERE ID=?";
		return jdbcTemplate.queryForObject(sql, Double.class, accountId);
		
	}

}
