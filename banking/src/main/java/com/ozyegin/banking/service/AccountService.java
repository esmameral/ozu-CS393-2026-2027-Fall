package com.ozyegin.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozyegin.banking.dto.BankAccountDTO;
import com.ozyegin.banking.model.BankAccount;
import com.ozyegin.banking.repository.BankAccountDAO;
import com.ozyegin.banking.repository.BankAccountRepository;

@Service
//@Transactional
public class AccountService {
	@Autowired
	BankAccountDAO repo;

	@Autowired
	BankAccountRepository bankAccountRepository;

	public List<BankAccount> listAccountByNameAndTrxAmount(String owner, double amount){
		return bankAccountRepository.findByOwnerAndTransactionsAmount(owner, amount);
	}
	
	public List<BankAccountDTO> getAccountDTOs(String owner) {
		return bankAccountRepository.getBankAccountDTOByOwner(owner);
	}
	
	public List<BankAccount> getAccounts(String owner) {
		return bankAccountRepository.findByOwner(owner);
	}

	public void addAccount(BankAccount acc) {
		bankAccountRepository.save(acc);
	}
	
	public List<String> getAccountNames() {
		return bankAccountRepository.getNames();
	}

	public List<BankAccount> getAll() {
		return bankAccountRepository.findAll();
	}

	public void transferMoney(int senderId, int receiverId, double amount) {
		repo.deposit(receiverId, amount);
		repo.withdraw(senderId, amount);

	}

	public double getBalance(int accountId) {
		return repo.getBalance(accountId);
	}
}
