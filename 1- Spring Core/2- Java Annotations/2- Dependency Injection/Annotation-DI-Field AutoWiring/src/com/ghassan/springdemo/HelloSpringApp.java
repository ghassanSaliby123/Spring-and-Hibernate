package com.ghassan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
	//Spring will scan java classes for special annotations
	//Register the beans in the spring container
	//We do the following:
	//1- Enable component scanning in Spring config file
	// 	<context:component-scan base-package="com.ghassan.springdemo"></context:component-scan>
	//2- add the @Component to java classes @Component(BeanID)
	//3- retrieve the bean from the spring container
	
	//For DI through Fields we do the following
	//a- define the dependency interface and class 
	//	FortuneService interface and HappyFortuneService class that implement the interface
	//	then we annotate this class with @component
	//b- We create an empty constructor in the class and apply the autowired annotation
	//directly to the field and no need for setter method
	//	Through the TennisCoach class we autowired the interface field
	//c- we configure this DI through @Atuowired for the interface field
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