package com.ozyegin.banking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="C_TRX_LIST")
public class ChequeTransaction extends WithdrawalTransaction {
	private String chequeNumber;
	
	public ChequeTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChequeTransaction(double amount,String chequeNumber) {
		super(amount,0);
		this.chequeNumber=chequeNumber;
		
	}

	@Override
	public void update(BankAccount account) {
		account.debit(getAmount()+getAmount()*5/1000);
	}

	public String getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	

}
