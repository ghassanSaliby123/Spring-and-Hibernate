package com.ghassan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	//Bean might have different scopes and here we cover the singleton and prototype
	//We can simply define the scope through @Scope("singleton/prototype")
	public static void main(String[] args) {

		//load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve beans from spring container
//		Coach tennisCoach1 = context.getBean("tennisCoach", Coach.class);//@Scope("singleton")
//		Coach tennisCoach2 = context.getBean("tennisCoach", Coach.class);//@Scope("singleton")

		Coach tennisCoach1 = context.getBean("tennisCoach", Coach.class);//@Scope("prototype")
		Coach tennisCoach2 = context.getBean("tennisCoach", Coach.class);//@Scope("prototype")

		//Check if they are the same objects
		if (tennisCoach1 == tennisCoach2) {
			System.out.println("They refer to the same object");
		}else {
			System.out.println("They refer to different objects");
		}
		System.out.println("The objects memory locations are:" );
		System.out.println(tennisCoach1 + "\n" + tennisCoach2);
	
		
		//close the context
		context.close();
	}

}