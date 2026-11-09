package com.ozyegin.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ozyegin.banking.dto.BankAccountDTO;
import com.ozyegin.banking.model.BankAccount;
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

	@Query("Select new com.ozyegin.banking.dto.BankAccountDTO(a.id,a.owner,a.balance) from BankAccount a where a.owner=?1")
	public List<BankAccountDTO> getBankAccountDTOByOwner(String a);
	
	public List<BankAccount> findByOwner(String a);
	
	public List<BankAccount> findByOwnerAndTransactionsAmount(String owner, double admount);

	@Query ("select distinct a.owner from BankAccount a")
	public List<String> getNames();
	
	 
	
	
}
