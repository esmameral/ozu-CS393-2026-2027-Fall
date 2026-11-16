package com.ozyegin.banking.advices;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ozyegin.banking.model.ErrorDetails;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_GATEWAY)
	@ExceptionHandler(RuntimeException.class)
	public ErrorDetails handleRuntimeExceptions(RuntimeException e) {
		ErrorDetails d=new ErrorDetails();
		d.setStatusCode(HttpStatus.BAD_GATEWAY.value());
		//d.setDetails(e.getCause().toString())=>throws Nullpointer exception internally;
		d.setDetails("A runtime exception occured");
		d.setException(e.getMessage());
		return d;		
	}
	
	@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
	@ExceptionHandler(Exception.class)
	public ErrorDetails handleGenericExceptions(Exception e) {
		ErrorDetails d=new ErrorDetails();
		d.setStatusCode(HttpStatus.EXPECTATION_FAILED.value());
		d.setDetails("An error occured");
		d.setException(e.getMessage());
		return d;		
	}
}
