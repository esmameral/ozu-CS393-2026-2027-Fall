package com.ozyegin.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ozyegin.banking.dto.BankAccountDTO;
import com.ozyegin.banking.model.BankAccount;
import com.ozyegin.banking.model.ErrorDetails;
import com.ozyegin.banking.service.AccountService;

@RestController
@RequestMapping("/accounts")
@ResponseStatus(HttpStatus.FOUND)
public class BankAccountController {
	@Autowired
	AccountService service;
	
	@GetMapping
	@RequestMapping("/{owner}")
	public List<BankAccountDTO> getOwners(@PathVariable("owner") String owner) {
		
		return service.getAccountDTOs(owner);
	}
	
//	Example for using ResponseEntity object with Http status code
//	@PostMapping()
//	public ResponseEntity<BankAccount> saveNewAccount(@RequestBody BankAccount acc) {
//		
//		BankAccount accNew=service.addAccount(acc);
//		return ResponseEntity.status(HttpStatus.CREATED).body(accNew);
//	}
	
//	Example for using HttpServletResponse object with status code
//	@PostMapping()
//	public BankAccount saveNewAccount(@RequestBody BankAccount acc, HttpServletResponse response) {
//		response.setStatus(HttpStatus.CREATED.value());
//		BankAccount accNew=service.addAccount(acc);
//		return accNew;
//	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public BankAccount saveNewAccount(@RequestBody BankAccount acc) throws Exception {
		BankAccount accNew=service.addAccount(acc);
		return accNew;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(RuntimeException.class)
	public ErrorDetails handleExceptions(RuntimeException e) {
		ErrorDetails d=new ErrorDetails();
		d.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		d.setDetails("An error occured");
		d.setException(e.getMessage());
		return d;
			
	}
	
	

}
