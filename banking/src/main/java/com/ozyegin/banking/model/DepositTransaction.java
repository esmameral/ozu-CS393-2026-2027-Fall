package com.ozyegin.banking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="DEPOSIT_TRX_LIST")
public class DepositTransaction extends Transaction {

	public DepositTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepositTransaction(double amount) {
		super(amount);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(BankAccount account) {
		account.credit(this.getAmount());
		
	}

}
