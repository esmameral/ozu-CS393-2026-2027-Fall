package com.ozyegin.myProject.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloMessageEn")
public class HelloMessageEnImpl implements HelloMessage {

	@Value("Hi, how are you?")
	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}

}
