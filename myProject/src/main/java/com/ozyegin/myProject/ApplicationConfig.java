package com.ozyegin.myProject;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import com.ozyegin.myProject.beans.IdNumber;

@Configuration
public class ApplicationConfig {
	@Bean
	@Scope("prototype")
	public IdNumber getNewId() {
		IdNumber idnumber=new IdNumber();
		idnumber.setId((int)(Math.random()*1000));
		return idnumber;
	}
	
	@Bean
	@Primary
	public SimpleDateFormat getDateFormat() {
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return df;
	}

	@Bean
	@Profile("dev")
	public SimpleDateFormat getDateFormat2() {
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		return df;
	}
}
