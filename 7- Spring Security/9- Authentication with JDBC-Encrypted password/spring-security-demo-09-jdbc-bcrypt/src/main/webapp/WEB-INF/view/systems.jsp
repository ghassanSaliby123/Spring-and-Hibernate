<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
	<title> Admin Page</title>
</head>

<body>
	<h2> Admin Page</h2>
	<hr>
	<P>
	Welcome to the Admin page!
	</P>
	<hr>
	<p>This is a meeting for Admins</p>
	<!-- add a logout button,, the uri should be logout (spring) -->
	<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
</body>

</html>