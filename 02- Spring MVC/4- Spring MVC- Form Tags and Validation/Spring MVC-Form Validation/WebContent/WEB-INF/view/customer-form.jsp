<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>customer form</title>
		<style type="text/css">
			.error{color:red}
		</style>
	</head>
	<body>
		<h2>Spring MVC Demo - Customer Form</h2>
		<hr>
		<form:form action="processForm" modelAttribute="customer">
			First name: <form:input path="firstName"/>
			<br><br>
			Last name (*): <form:input path="lastName"/>
			<form:errors path="lastName" cssClass="error"/>
			<br><br>
			Free Passes: <form:input path="freePasses"/>
			<form:errors path="freePasses" cssClass="error"/>
			<br><br>
			PostalCode : <form:input path="postalCode"/>
			<form:errors path="postalCode" cssClass="error"/>
			<br><br>
			CourseCode : <form:input path="courseCode"/>
			<form:errors path="courseCode" cssClass="error"/>
			<br><br>
			<input type="submit" value="submit">
		</form:form>
	</body>
</html>