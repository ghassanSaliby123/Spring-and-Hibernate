package com.ghassan.springdemo;

public class BaseballCoach implements Coach{

	//define a private field for the interface and a constructor for the DI
	private FortuneService fortuneService;
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkOut() {
		return "BaseballCoach -> getDailyWorkOut()....Spend 30 minutes on batting practicing";
	}

	@Override
	public String getDailyFortune() {
		//Use the fortuneService to get a fortune
		return "BaseballCoach -> getDialyFortune()-> " + fortuneService.getFortune();
	}
	
	
}
