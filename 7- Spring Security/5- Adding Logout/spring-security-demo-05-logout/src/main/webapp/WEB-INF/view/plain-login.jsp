<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<title>Login Form</title>
	<style type="text/css">
		.error{color:red;}
		
	</style>
</head>

<body>
	<h3>My Custom Login Page</h3>
	
	<!-- Through this form we send data to authenticateTheUser 
	that is defined in the Security Config class with method POST -->
	<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method = "POST">
		<!-- Check the error param to see if there is an error -->
		<c:if test="${param.error != null }">
			<i class="error">Sorry.. invalid username/password </i>
		</c:if>
		<p>
		<!-- the names(username, password) are recoginzed by spring security -->
			User name: <input type="text" name="username"/>
		</p>
		<p>
		<!-- the names(username, password) are recoginzed by spring security -->
			Password: <input type="password" name="password"/>
		</p>
		<input type="submit" value="Login"/>
	</form:form>
</body>

</html>