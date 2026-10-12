package com.ozyegin.banking.model;

import java.util.Date;

public abstract class Transaction {
	private int id;
	private double amount;
	private Date date=new Date();
	public Transaction(double amount) {
		super();
		this.amount = amount;
		this.id=(int)(Math.random()*1000);
	}
	
	public abstract void update(BankAccount account);
	
	public int getId() {
		return id;
	}
	private void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	private void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	private void setDate(Date date) {
		this.date = date;
	}
	

}
