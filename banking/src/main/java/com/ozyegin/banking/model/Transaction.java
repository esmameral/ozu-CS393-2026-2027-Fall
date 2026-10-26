package com.ozyegin.banking.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
//@Table(name="TRX_LIST")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private double amount;
	private Date date=new Date();
	@ManyToOne
	@JoinColumn(name = "BANK_ACCOUNT_ID")
	private BankAccount account;
	
	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	public Transaction() {
		super();
	}
	public Transaction(double amount) {
		super();
		this.amount = amount;
		//this.id=(int)(Math.random()*1000);
	}
	
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", amount=" + amount + "] "+getClass().getSimpleName();
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
