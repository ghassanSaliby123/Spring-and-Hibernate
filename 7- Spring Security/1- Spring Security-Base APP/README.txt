In order to configure a Spring MVC app with Java Class instead of XML we do the following:
1- Create a config class and annotate it with @Configuration, @ComponentScan(targetPackage), @EnableWebMVC
2- Add the Beans in this class for instance the viewResolver bean and tha data source bean... .etc
3- Create a class that extends the AbstranctAnnotationConfigurDispatcherServletInitializer
in this class we refer to the config class and we add the request mapping (It works as a front controller)
