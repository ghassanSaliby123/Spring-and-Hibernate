<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<body>
		<h2>Spring MVC Demo - Student Form</h2>
		<hr>
		<form:form action="processForm" modelAttribute="student">
			First name: <form:input path="firstName"/>
			<br><br>
			Last name: <form:input path="lastName"/>
			<br><br>
			Country: <form:select path="country">
				<form:option value="Brazil" label="Brazil"/>
				<form:option value="France" label="France"/>
				<form:option value="Germany" label="Germany"/>
				<form:option value="Belgium" label="Belgium"/>
				<form:option value="Sweden" label="Sweden"/>
			</form:select>
			<br><br>
			Favorite Programming Language:
			Java <form:radiobutton path="favoriteLanguage" value="Java"/>
			C# <form:radiobutton path="favoriteLanguage" value="C#"/>
			PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
			Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
			<br><br>
			Operating System:
			MS Windows <form:checkbox path="operatingSystems" value="Ms Windows"/>
			Mac Os <form:checkbox path="operatingSystems" value="Mac Os"/>
			Linux <form:checkbox path="operatingSystems" value="Linux"/>
			<br><br>
		<input type="submit" value="submit">
		</form:form>
		
	</body>
</html>