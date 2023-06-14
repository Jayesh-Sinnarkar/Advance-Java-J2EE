<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h5>Emp Address : ${requestScope.emp_adr}</h5>
	<h5>
		<a href="<spring:url value='/emp/list?chosenDept=${sessionScope.selected_dept.id}'/>">Back</a>
	</h5>

</body>
</html>