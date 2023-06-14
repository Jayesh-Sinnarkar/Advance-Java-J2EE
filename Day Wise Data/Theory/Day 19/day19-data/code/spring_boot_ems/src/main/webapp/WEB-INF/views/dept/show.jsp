<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<spring:url var="url" value="/emp/list" />
	<form action="${url}" method="get">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Choose Department</td>
				<td><select name="chosenDept">
						<c:forEach var="dept" items="${requestScope.departments}">
							<option value="${dept.id}">${dept.deptName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Choose A Department" /></td>
			</tr>
		</table>
	</form>
</body>
</html>