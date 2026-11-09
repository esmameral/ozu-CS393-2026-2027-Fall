package com.ozyegin.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ozyegin.banking.dto.BankAccountDTO;
import com.ozyegin.banking.model.BankAccount;
import com.ozyegin.banking.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class BankAccountController {
	@Autowired
	AccountService service;
	
	@GetMapping
	@RequestMapping("/{owner}")
	public List<BankAccountDTO> getOwners(@PathVariable("owner") String owner) {
		return service.getAccountDTOs(owner);
	}
	
	@PostMapping
	public String saveNewAccount(@RequestBody BankAccount acc) {
		service.addAccount(acc);
		return "success";
	}

}
