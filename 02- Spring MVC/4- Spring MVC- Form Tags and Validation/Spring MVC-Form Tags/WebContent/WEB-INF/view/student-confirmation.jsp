
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<body>
		<h2>Spring MVC Demo - Confirmation Page</h2>
		<hr>
		The Student is confirmed : ${student.firstName } ${student.lastName}
		<br><br>
		Country: ${student.country }
		<br><br>
		The favorite Programming is : ${student.favoriteLanguage }
		<br><br>
		The selected operating systems: 
		<ul>
			<c:forEach var = "temp" items="${student.operatingSystems}">
			<li>${temp}</li>
			</c:forEach>
		</ul>
	</body>
</html>