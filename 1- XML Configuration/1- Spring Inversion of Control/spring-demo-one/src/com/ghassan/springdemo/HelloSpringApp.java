package com.ghassan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
//The application context is mostly referred as Spring container
	public static void main(String[] args) {
		

		//load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve beans from spring container
		Coach baseballCoach = context.getBean("baseballCoach", Coach.class);
		Coach trackCoach = context.getBean("trackCoach", Coach.class);
		Coach basketballCoach = context.getBean("basketballCoach", Coach.class);
		
		//call methods on the bean
		System.out.println(baseballCoach.getDailyWorkOut());
		System.out.println(trackCoach.getDailyWorkOut());
		System.out.println(basketballCoach.getDailyWorkOut());

		
		//close the context
		context.close();
	}

}
