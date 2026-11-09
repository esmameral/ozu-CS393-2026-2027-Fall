package com.ozyegin.banking.dto;

public class BankAccountDTO {
	private int id;
	private String owner;
	
	private double balance;
	public BankAccountDTO(int id, String owner, double balance) {
		super();
		this.id = id;
		this.owner = owner;
		this.balance = balance;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
