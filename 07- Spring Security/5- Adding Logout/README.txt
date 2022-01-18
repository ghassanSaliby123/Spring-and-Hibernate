We can add logout to the page through Spring security as well 
1- Through the config security class, we add the logout in the configure method
2- Add a button for logout inside a form in the home page, the action should refer to the logout url which is a default url in Spring security for logout 
3- We can check if the user logged out by checking the param.logout ig it is null or not
