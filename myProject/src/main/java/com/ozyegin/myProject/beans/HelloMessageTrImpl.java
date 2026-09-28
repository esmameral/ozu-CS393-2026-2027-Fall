package com.ozyegin.myProject.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("helloMessageTr")
@Primary
public class HelloMessageTrImpl implements HelloMessage {

	@Value("Merhaba, Nasılsınız?")
	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}

}
