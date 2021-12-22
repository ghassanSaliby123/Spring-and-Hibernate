package com.ghassan.springdemo;

public class TrackCoach implements Coach {

	//private field and constructor for DI
	FortuneService fortuneService;
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	

	@Override
	public String getDailyWorkOut() {
		return "TrackCoach -> getDailyWorkOut()....Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "TrackCoach -> getDailyFortune() -> " + fortuneService.getFortune();
	}

}
