Adding authorization based on the user role
1- In the security config class we add to configure method the matchers between each url and the user role
2- we use the spring security tag library 
3- we get the user name and the user role in the home page through <security:authentication> tag
4- we show links based on the user role by using the <security:authorize> tag
5- we add an access denied page in the security config class
