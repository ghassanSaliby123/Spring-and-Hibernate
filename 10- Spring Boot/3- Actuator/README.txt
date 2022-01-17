- Spring Boot Actuator exposes rest endpoints to monitor and manage the app.
these endpoints has prefix /actuator such as ../actuator/health: to show the health infomramtion
/actuator/info  to show info about app(we can write the info in the property file)
- We can add security for the exposed endpoints through the property file:
spring.security.user.name=<>
spring.security.user.password=<>
