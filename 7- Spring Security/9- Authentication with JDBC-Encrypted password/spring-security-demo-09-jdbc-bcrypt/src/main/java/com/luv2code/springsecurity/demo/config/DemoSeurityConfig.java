package com.luv2code.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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

	//add a reference to our security datasource
	@Autowired
	private DataSource securityDataSource;
	
	//ADD user name, pass, role in ,memory
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//use jdbc authentication 
		auth.jdbcAuthentication().dataSource(securityDataSource);
		}

	//Addign a new login form
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//for all the authorized http requests they should be authenticated 
		//and the login form is given by login page 
		//to process the data use the loginProcessUrl 
		//Spring security check username, passowrd fields and permit 
		http.authorizeRequests()
			.antMatchers("/").hasRole("EMPLOYEE") //add authorization depending on the role
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout()//add the logout
			.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");//add an access denied page 
	}

	//configure new login form 
	
}
