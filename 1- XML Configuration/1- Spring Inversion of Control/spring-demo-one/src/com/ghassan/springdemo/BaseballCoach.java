package com.ghassan.springdemo;

public class BaseballCoach implements Coach{

	@Override
	public String getDailyWorkOut() {
		return "BaseballCoach....Spend 30 minutes on batting practicing";
	}
}
