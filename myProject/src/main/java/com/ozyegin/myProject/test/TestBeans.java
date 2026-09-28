package com.ozyegin.myProject.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ozyegin.myProject.ApplicationConfig;
import com.ozyegin.myProject.MyProjectApplication;
import com.ozyegin.myProject.beans.GreetingService;
import com.ozyegin.myProject.beans.IdNumber;

public class TestBeans {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyProjectApplication.class);
		
		GreetingService service1= context.getBean("greetingService",GreetingService.class);
		service1.sayHello();
		
		GreetingService service2= context.getBean("greetingService",GreetingService.class);
		service2.sayHello();
		System.out.println(service1==service2);
		
		IdNumber in1=context.getBean(IdNumber.class);
		System.out.println(in1.getId());
		
		IdNumber in2=context.getBean(IdNumber.class);
		System.out.println(in2.getId());
		System.out.println(in1==in2);


	}

}
