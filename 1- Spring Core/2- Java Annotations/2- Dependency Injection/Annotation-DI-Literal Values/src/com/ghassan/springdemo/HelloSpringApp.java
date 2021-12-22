package com.ghassan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	//When we want to inject literal values through spring 
	//1- add the property file to the spring config file
	//	 <context:property-placeholder location="classpath:sport.properties"/>
	//2- Add the fields to the class which we want to inject the values for
	//3- Then we annotate these fields with @Value(${foo.team})
	public static void main(String[] args) {

		//load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve beans from spring container
		TennisCoach tennisCoach = context.getBean("tennisCoach", TennisCoach.class);
		
		//get methods from this bean
		System.out.println(tennisCoach.getName());
		System.out.println(tennisCoach.getEmail());
		
		//close the context
		context.close();
	}

}