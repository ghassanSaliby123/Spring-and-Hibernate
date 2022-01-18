package com.ghassan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	//As discussed before we can add init and destroy methods to the beans 
	//With annotation we simply annotate the initialization methods with @PostConstruct
	//and the destroy methods with @Predestroy 
	//These methods can have any access modifier, any return type but should not have arguments
	//Note: preDestroy doesn't work with bean that has a prototype scope
	//We can destroy it through implementing the DisposableBean interface then we call destroy method
	public static void main(String[] args) {

		//load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve beans from spring container
//		Coach tennisCoach1 = context.getBean("tennisCoach", Coach.class);//@Scope("singleton")
//		Coach tennisCoach2 = context.getBean("tennisCoach", Coach.class);//@Scope("singleton")

		Coach tennisCoach = context.getBean("tennisCoach", Coach.class);//With init and destroy 
		
		//Show the init and destroy methods
		
		//close the context
		context.close();
	}

}