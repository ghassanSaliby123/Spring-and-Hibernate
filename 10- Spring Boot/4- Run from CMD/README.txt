- Since the spring boot has an embedded server, we can run it in the command line using the jar or the war packaging
1- provide a jar file through maven plugin 
mvnw package (in case we dont have maven installed). mvn package (in case we have maven installed)
-----> have a jar file in the target folder
2- two methods of running: on the target folder:
java -jar myapp.jar
OR
mvnw spring-boot:run
