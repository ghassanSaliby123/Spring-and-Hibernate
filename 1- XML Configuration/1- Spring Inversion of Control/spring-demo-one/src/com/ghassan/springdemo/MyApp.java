package com.ghassan.springdemo;

public class MyApp {

	public static void main(String[] args) {

		Coach baseballCoach = new BaseballCoach();
		Coach trackCoach = new TrackCoach();
		System.out.println(baseballCoach.getDailyWorkOut());
		System.out.println(trackCoach.getDailyWorkOut());
	}

}
