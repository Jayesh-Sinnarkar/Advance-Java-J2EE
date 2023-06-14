<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h5 align='center'>${requestScope.status}</h5>
	<table style="background-color: lightgrey; margin: auto">
		<caption>Employees from Department :
			${sessionScope.selected_dept.deptName}</caption>
		<tr>
			<th>Emp ID</th>
			<th>Name</th>
			<th>Salary</th>
			<th>Join Date</th>
			<th>Employment Type</th>
			<th>Address</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<c:forEach var="emp" items="${requestScope.emp_list}">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.firstName}${emp.lastName}</td>
				<td>${emp.salary}</td>
				<td>${emp.joinDate}</td>
				<td>${emp.type}</td>
				<td><a href="<spring:url value='/emp/show_adr?id=${emp.id}'/>">Show
						Address</a></td>
				<td><a href="<spring:url value='/emp/update?id=${emp.id}'/>">Update</a></td>
				<td><a href="<spring:url value='/emp/delete/${emp.id}'/>">Delete</a>
			</tr>
		</c:forEach>
		<tr>
			<td><a href="<spring:url value='/emp/add'/>">Add New
					Employee</a></td>
		</tr>
	</table>

</body>
</html>