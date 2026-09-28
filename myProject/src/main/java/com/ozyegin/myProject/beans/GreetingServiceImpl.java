package com.ozyegin.myProject.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("greetingService")
//@Scope("prototype")
public class GreetingServiceImpl implements GreetingService {

	@Autowired
	@Qualifier("helloMessageEn")
	private HelloMessage message;
	
	@Autowired
	private IdNumber in;
	
	@Autowired
	private SimpleDateFormat simpleDateFormat;
	
	@Override
	public void sayHello() {
		System.out.println(message.getMessage()+" ID:"+in.getId()+" current date:"+
				simpleDateFormat.format(new Date()));
	}

}
