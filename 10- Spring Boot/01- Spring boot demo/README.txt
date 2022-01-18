- Simple spring boot app with rest controller
- mvnw: wrapper for maven. No need to have maven installed or present on your path, it automatically downlaods an upadetes maven version.
if you already have maven, no need for these files
- @SpringBootApplication: composed of other annotations (@EnableAutoConfiguration, @ComponentScan, @Configuration)
- pringApplication.run(): it bootstraps the spring boot application, through this it creates the application context, register all the beans 
and it starts the embeded server 
- /resources/ application.properties: add application properties such as, context path, server port, actuator endpoints, security uerName and password......
- static: js, html, css, pdf... 
