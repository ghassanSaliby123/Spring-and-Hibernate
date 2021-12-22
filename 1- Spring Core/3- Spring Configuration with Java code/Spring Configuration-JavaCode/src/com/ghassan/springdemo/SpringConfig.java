package com.ghassan.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
public class SpringConfig {

	//define bean for happyFortuneSerive
	@Bean
	public FortuneService happyFortuneService() {
		return new HappyFortuneService();
	}
	//define bean for tennisCoah and inject dependency
	@Bean
	public Coach tennisCoach() {
		return new TennisCoach(happyFortuneService());
	}
}
