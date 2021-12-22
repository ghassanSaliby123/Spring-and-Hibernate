package com.ghassan.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("tennisCoach")
@Scope("singleton")
public class TennisCoach implements Coach {

	//Add private field for the interface for DI 
	//Add the qualifier for the class that we want to inject in
	@Autowired
	FortuneService fortuneService;
	
	//Add empty constructor
	public TennisCoach() {
	}
	
	//Initialization method
	@PostConstruct
	public void init_method() {
		System.out.println("This inside the initialization method....@PostConstruct");
	}
	
	@PreDestroy
	public void destroy_method() {
		System.out.println("This inside the destroy method....@PreDestroy");
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
