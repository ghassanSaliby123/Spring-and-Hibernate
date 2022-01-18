
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Customer Confirmation</title>
	</head>
	<body>
		<h2>Spring MVC Demo - Confirmation Page</h2>
		<hr>
		The customer is confirmed : ${customer.firstName } ${customer.lastName}
		<br><br>
		Free passes : ${customer.freePasses }
		<br><br>
		PostalCode : ${customer.postalCode }
		<br><br>
		CourseCode : ${customer.courseCode }
	</body>
</html>