package com.ghassan.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "HappyFortuneService -> getFortune()...Today is your lucky day";
	}

}
