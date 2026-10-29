package com.ozyegin.banking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEPOSIT_TRX_LIST")
public class DepositTransaction extends Transaction {
	private String channel;

	public DepositTransaction() {
		super();
	}

	public DepositTransaction(double amount, String channel) {
		super(amount);
		this.setChannel(channel);
	}

	@Override
	public void update(BankAccount account) {
		account.credit(this.getAmount());

	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	
}
