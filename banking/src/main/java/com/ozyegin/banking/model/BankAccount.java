package com.ozyegin.banking.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Entity
@Table(name = "BANK_ACCOUNT")
public class BankAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int accountId;
	
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BankAccount [accountId=" + accountId + ", owner=" + owner + ", balance=" + balance + "]";
	}

	@Column(nullable = false,length = 30)
	private String owner;
	private Date createDate =new Date();
	private double balance;
	@OneToMany(mappedBy = "account",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	private List<Transaction> transactions=new ArrayList<Transaction>();
	
	// transactionList

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public BankAccount(String owner, int id) {
		setAccountId(id);
		setOwner(owner);
	}
	
	public BankAccount(String owner) {
		setOwner(owner);
	}


	public void credit(double trxAmount) {
		this.balance+=trxAmount;
		
	}
	public void debit(double trxAmount) {
		this.balance-=trxAmount;
		
	}

	public double getBalance() {
		return balance;
	}

	public void post(Transaction aTransaction) {
		aTransaction.update(this);	
		aTransaction.setAccount(this);
		transactions.add(aTransaction);
	}
}
