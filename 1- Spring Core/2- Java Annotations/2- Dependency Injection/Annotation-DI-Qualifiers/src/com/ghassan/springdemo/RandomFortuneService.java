package com.ghassan.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "RandomFortuneService --> getFortune()...Fortune from Random";
	}

}
