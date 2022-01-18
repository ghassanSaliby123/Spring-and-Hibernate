package com.ghassan.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("tennisCoach")
@Scope("prototype")
public class TennisCoach implements Coach {

	//Add private field for the interface for DI 
	//Add the qualifier for the class that we want to inject in
	@Autowired
	FortuneService fortuneService;
	
	//Add empty constructor
	public TennisCoach() {
	}
	
	
	@Override
	public String getDailyWorkOut() {
		return "TennisCoach -> getDailyWorkOut()....Practice your volley";
	}
	

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "TennisCoach --> getDailyFortune() --> " + fortuneService.getFortune();
	}	

}
