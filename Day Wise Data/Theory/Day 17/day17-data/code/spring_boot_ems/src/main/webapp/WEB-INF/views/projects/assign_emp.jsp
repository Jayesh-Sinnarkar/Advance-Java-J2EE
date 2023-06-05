<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Assign Employee Form</title>
</head>
<body>
	<form method="post">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Project ID(R)</td>
				<td><input type="number" readonly name="projectId"
					value="${param.projectId}" /></td>
			</tr>
			<tr>
			<td>Enter Employee ID</td>
				<td><input type="number" name="empId" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Assign Employee" /></td>
			</tr>
		</table>
	</form>
</body>
</html>