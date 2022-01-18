package com.ghassan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
	//Spring will scan java classes for special annotations
	//Register the beans in the spring container
	//We do the following:
	//1- Enable component scanning in Spring config file
	// 	<context:component-scan base-package="com.ghassan.springdemo"></context:component-scan>
	//2- add the @Component to java classes
	//@Component(BeanID.. by default it is the class name, the first letter is lowercase
	//3- retrieve the bean from the spring container
	public static void main(String[] args) {
		

		//load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve beans from spring container
		Coach tennisCoach = context.getBean("tennisCoach", Coach.class);//IoC
		
		//get methods from this bean
		System.out.println(tennisCoach.getDailyWorkOut());
	
		
		//close the context
		context.close();
	}

}