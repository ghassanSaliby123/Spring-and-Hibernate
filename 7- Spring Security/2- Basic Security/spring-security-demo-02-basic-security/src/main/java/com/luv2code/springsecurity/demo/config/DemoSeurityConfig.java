package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSeurityConfig extends WebSecurityConfigurerAdapter {

	//set the username ,password , role
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//add our users in memory for authentication 
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(users.username("ghassan").password("test123").roles("EMPLOYEE"))
		.withUser(users.username("mary").password("test123").roles("MANAGER"))
		.withUser(users.username("susan").password("test123").roles("ADMIN"));
		}
	
	//reference our custom login form 

}
