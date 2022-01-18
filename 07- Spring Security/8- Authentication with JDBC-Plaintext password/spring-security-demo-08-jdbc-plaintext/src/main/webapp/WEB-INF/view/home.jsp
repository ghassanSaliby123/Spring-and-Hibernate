<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
	<title> Company Home Page</title>
</head>

<body>
	<h2> Company Home Page</h2>
	<hr>
	<P>
	Welcome to the company home page!
	</P>
	<hr>
		<!-- Display user name and role -->
		<p>
			User: <security:authentication property="principal.username"/>
			<br><br>
			Role(s): <security:authentication property="principal.authorities"/>
		</p>
	<hr>
		
		<!-- Add a link for /leadres.. this is for MANAGER role -->
		<!-- Show the links based on the user role -->
		<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
			(only for manager)
		</p>
		</security:authorize>

		<!-- Add a link for /systems.. this is for ADMIN role -->
		<!-- Show the links based on the user role -->
		<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
			(only for Admin)
		</p>
		</security:authorize>
	<hr>
	<!-- add a logout button,, the uri should be logout (spring) -->
	<form:form action="${pageContext.request.contextPath}/logout" method= "POST">
		<input type="submit" value="Logout"/>
	</form:form>
</body>

</html>