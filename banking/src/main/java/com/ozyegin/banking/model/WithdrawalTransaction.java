package com.ozyegin.banking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="WITHD_TRX_LIST")
public class WithdrawalTransaction extends Transaction {

	public WithdrawalTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WithdrawalTransaction(double amount) {
		super(amount);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void update(BankAccount account) {
		account.debit(this.getAmount());
		
	}
}
