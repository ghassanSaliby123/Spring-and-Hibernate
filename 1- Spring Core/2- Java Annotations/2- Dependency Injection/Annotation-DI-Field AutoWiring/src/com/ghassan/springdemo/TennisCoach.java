package com.ghassan.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tennisCoach")
public class TennisCoach implements Coach {

	//Add private field for the interface for DI 
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
