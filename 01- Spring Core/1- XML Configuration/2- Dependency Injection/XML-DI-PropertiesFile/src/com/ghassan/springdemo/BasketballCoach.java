package com.ghassan.springdemo;

public class BasketballCoach implements Coach {

	//Private fields for literal values setter injection 
	private String team;
	private String emailAddress;
	//Setter methods for DI
	public void setTeam(String team) {
		this.team = team;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public BasketballCoach() {
		
	}
	public String getTeam() {
		return team;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	@Override
	public String getDailyWorkOut() {
		return "BasketballCoach....Train for one on onq deffence";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
