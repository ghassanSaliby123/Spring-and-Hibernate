property file contains lot of info about the app 
- we can write properly name=value and inject the value in the app through @Value("${name}")
- define the app acontext path: server.servlet.context-path=/myapp
- define security username and pass
- define the server port
- expose endpoints for the actuator: management.endpoints.web.exposure.include=*
- define the data source driver, url, username, password
- ect........
