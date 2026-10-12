package com.ozyegin.banking.model;

public class WithdrawalTransaction extends Transaction {

	public WithdrawalTransaction(double amount) {
		super(amount);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void update(BankAccount account) {
		account.debit(this.getAmount());
		
	}
}
