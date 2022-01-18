package com.ghassan.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {


	//Configure Spring container using java code without XML or component scan for @Copmonent
	//1- Create a java class and annotate it with @Configuration
	//		@Configuration
	//		class springConfig{}
	//2- Add component scanning support @ComponentScan("package") which scans all classes that 
	//	have @Component
	//		@Configuration
	//		@ComponentScan("package name")
	//		class springConfig{}
	//	 - If we don't add the @Coponentscan we have to do the following:
	//		a- Define method to expose the bean in the config class and annotate it with @Bean
	//			@Bean
	//			Coach swimCoach(){
	//					SwimCoach mySwimCoach = new SwimCoach();
	//					return mySwimCoach;}
	//		the method name here is the bean ID that will be registered in the spring container
	//		b- As for DI : we add @bean for FortuneService
	//			@Bean
	//			FortuneServie happyFortuneService(){
	//					
	//					return new HappyFortuneService();}
	//  		Then we inject this bean to swimCoach
	//			@Bean
	//			Coach swimCoach(){
	//					SwimCoach mySwimCoach = new SwimCoach(happyFortuneService());
	//					return mySwimCoach;}
	//
	//3- Read Spring java configuration class
	//		AnnotationConfigApplicationContext context = 
	//					new AnnotationConfigApplicationContext(SpingConfig.class)
	//4- Retrieve beans from Spring container
	//		context.getBean()
	//5- Then we close the context.close()
	
	
	//If we want to inject values to fields using property file 
	//we add @PropertySource("classpath:sport.properties") to the config class
	//then we add @Value("${foo.team}") to field that we want to set the value for
	public static void main(String[] args) {

		//load the spring configuration file
	AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(SpringConfig.class);
		//retrieve beans from spring container
		Coach tennisCoach = context.getBean("tennisCoach", Coach.class);//IoC
		TennisCoach tennisCoach2 = context.getBean("tennisCoach", TennisCoach.class);//IoC

		//call a method from the bean
		System.out.println(tennisCoach.getDailyWorkOut());
		System.out.println(tennisCoach.getDailyFortune());
		
		//retrieve the fields values 
		System.out.println("The team name is : " + tennisCoach2.getTeam()
		+ "\nThe team email is : " + tennisCoach2.getEmail());
		//close the context
		context.close();
	}

}