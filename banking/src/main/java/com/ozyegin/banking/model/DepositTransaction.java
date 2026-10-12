package com.ozyegin.banking.model;

public class DepositTransaction extends Transaction {

	public DepositTransaction(double amount) {
		super(amount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(BankAccount account) {
		account.credit(this.getAmount());
		
	}

}
