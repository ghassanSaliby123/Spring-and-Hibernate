<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<!-- add a logout button,, the uri should be logout (spring) -->
	<form:form action="${pageContext.request.contextPath}/logout" method= "POST">
		<input type="submit" value="Logout"/>
	</form:form>
</body>

</html>