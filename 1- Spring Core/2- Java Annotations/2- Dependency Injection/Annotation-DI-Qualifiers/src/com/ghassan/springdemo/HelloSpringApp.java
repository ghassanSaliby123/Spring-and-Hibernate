package com.ghassan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	//If we have several classes that implement the interface which we want to inject it 
	//Spring will complain because it doesn't know which class should be injected 
	//Therefore we can use @Qulifier(bean id) to determine which class we want to inject 
	//We write this annotation after the @Autowired 
	//It works with the constructor injection, setter injection and field injection 
	
	//In this example we have Happy, random, database and rest fortuneServices and all of them 
	//implement the fortuneServie interface, 
	//Through the DI we set the @Qulifier() for the class that we expect to have it implementation
	
	public static void main(String[] args) {

		//load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve beans from spring container
		Coach tennisCoach = context.getBean("tennisCoach", Coach.class);//IoC
		
		//get methods from this bean
		System.out.println(tennisCoach.getDailyWorkOut());
		System.out.println(tennisCoach.getDailyFortune());
		
		//close the context
		context.close();
	}

}