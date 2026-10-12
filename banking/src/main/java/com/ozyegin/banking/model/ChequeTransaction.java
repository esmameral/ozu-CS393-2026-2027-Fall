package com.ozyegin.banking.model;

public class ChequeTransaction extends WithdrawalTransaction {

	public ChequeTransaction(double amount) {
		super(amount);
		
	}

	@Override
	public void update(BankAccount account) {
		account.debit(getAmount()+getAmount()*5/1000);
	}
	

}
