package com.ghassan.springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		
		return "HappyFortuneService -> getFortune()....Today is your lucky day";
	}

}
