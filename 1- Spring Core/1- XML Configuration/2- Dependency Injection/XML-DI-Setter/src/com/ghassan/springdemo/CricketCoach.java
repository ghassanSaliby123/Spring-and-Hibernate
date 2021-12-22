package com.ghassan.springdemo;

public class CricketCoach implements Coach {

	//private field for fortuneService
	private FortuneService fortuneService;
	//Setter method for DI
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	//no args constructor
	public CricketCoach() {
	}


	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "CricketCoach -> getDailyWorkOut()....run around for 3km";
	}

	

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return  "CricketCoach -> getDialyFortune()-> " + fortuneService.getFortune();
	}

}
