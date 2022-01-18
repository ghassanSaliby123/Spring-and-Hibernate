<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>

<head>
	<title> Leaders Page</title>
</head>

<body>
	<h2> Leaders Page</h2>
	<hr>
	<P>
	Welcome to the Leaders page!
	</P>
	<hr>
		<p>
			This meeting is only for Managers
	 </p>
	<hr>
	<!-- add a logout button,, the uri should be logout (spring) -->
	<a href="${pageContext.request.contextPath}/">Back to Home Page</a>
</body>

</html>