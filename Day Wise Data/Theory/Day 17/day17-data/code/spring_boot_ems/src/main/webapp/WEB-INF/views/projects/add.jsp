<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Launch New Project</title>
</head>
<body>
	<%--title,  startDate,  endDate --%>
	<form:form method="post" modelAttribute="project">
		<table style="background-color: lightgrey; margin: auto">
			<caption>Project Launching Form</caption>

			<tr>
				<td>Enter Project Title</td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td>Select Start Date</td>
				<td><form:input type="date" path="startDate" /></td>
			</tr>
			<tr>
				<td>Select End Date</td>
				<td><form:input type="date" path="endDate" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Launch New Project" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>