package com.ozyegin.banking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "WITHD_TRX_LIST")
public class WithdrawalTransaction extends Transaction {
	private double fee;

	public WithdrawalTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WithdrawalTransaction(double amount, double fee) {
		super(amount);
		this.fee = fee;
	}

	@Override
	public void update(BankAccount account) {
		account.debit(this.getAmount());

	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
}
