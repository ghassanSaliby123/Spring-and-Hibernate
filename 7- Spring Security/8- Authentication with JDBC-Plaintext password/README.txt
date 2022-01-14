Instead of storing user data (username, password, roles) in the memory, we save them in a database 
1- we add sql and pool dependencies in pom file
2- add properties file to store the jdbc driver, url , username, password
3- add beans to the application configuration class 
  a- adding environment to read the properties file
  b- add bean for data source
4- in the security configuration class we inject the data source
5- Then we authenticate the requests based on the info in the database

This example is supported with sql script to create the Mysql scheme 
The passwords in this scheme are not encrypted 
