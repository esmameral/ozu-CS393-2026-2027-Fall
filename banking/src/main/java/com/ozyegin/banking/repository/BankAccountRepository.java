package com.ozyegin.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozyegin.banking.model.BankAccount;
//@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

}
