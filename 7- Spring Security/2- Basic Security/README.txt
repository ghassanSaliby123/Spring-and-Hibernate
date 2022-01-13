In order to add a Spring Security to the project we do the following: 
1- Add dependencies to the pom file for (spring security web) and (spring security config)
  both of them should be combatible with spring mvc framework version
2- Create a Spring security initializer by extending the AbstractSecurityWebApplicationInitializer 
   through this class we can register the the spring filters that filters the requests depending on the 
   authentication and the autherization 
3- Create a Spring security Configuration class , annotate it with @Configuraion and @EnableWebecurity
  and extend WebSecurityConfigurerAdapter to configure the user , password, and role
4- add users, passwords for authentication and roles for authorization 
we override the method configure from the WebSecurityConfigurerAdapter class to add user,pass,role
we can add them in memory or a database
5- Spring provide a default web page for user login
