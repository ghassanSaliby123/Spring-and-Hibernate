package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSeurityConfig extends WebSecurityConfigurerAdapter {

	//ADD user name, pass, role in ,memory
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//add our users fir in memory authentication 
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(users.username("ghassan").password("test123").roles("EMPLOYEE"))
		.withUser(users.username("mary").password("test123").roles("MANAGER"))
		.withUser(users.username("susan").password("test123").roles("ADMIN"));
		}

	//Addign a new login form
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//for all the authorized http requests they should be authenticated 
		//and the login form is given by login page 
		//to process the data use the loginProcessUrl 
		//Spring security check username, passowrd fields and permit 
		http.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout()//add the logout
			.permitAll();
	}

	//configure new login form 
	
}
