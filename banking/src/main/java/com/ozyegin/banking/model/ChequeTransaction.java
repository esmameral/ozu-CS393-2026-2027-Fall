package com.ozyegin.banking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="CHEQUE_TRX_LIST")
public class ChequeTransaction extends WithdrawalTransaction {

	public ChequeTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChequeTransaction(double amount) {
		super(amount);
		
	}

	@Override
	public void update(BankAccount account) {
		account.debit(getAmount()+getAmount()*5/1000);
	}
	

}
