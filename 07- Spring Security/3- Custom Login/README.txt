Instead if using the default Srping security login page we create out custome one
1- Through security configuration, we override the configure(httpSecurity) method
2- We add the login url page and the login processing url
3- We create a controller method for the login url page
4- the processing url is handled by Spring security, so no need to add a controller method for it 
5- create a login in page, we add a from with action to the processing url and the method should be POST
6- We can check if data is valid by checking the param.error 
