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
	<h3>Project List</h3>
	<c:if test="${!empty requestScope.projects_list}">
		<table style="background-color: lightgrey; margin: auto">
			<caption>All Projects</caption>
			<tr>
				<th>Project ID</th>
				<th>Title</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Project Status</th>
				<!-- <th>No Of Employees</th> -->
				<th>Action</th>
			</tr>
			<c:forEach var="project" items="${requestScope.projects_list}">
				<tr>
					<td>${project.id}</td>
					<td>${project.title}</td>
					<td>${project.startDate}</td>
					<td>${project.endDate}</td>
					<td>${project.status}</td>
				<%-- 	<td>${project.emps.size()}</td> --%>
					<td><a
						href="<spring:url value='/projects/assign_emp?projectId=${project.id}'/>">Assign
							Employee</a></td>
				</tr>
			</c:forEach>
		</table>

	</c:if>
	<h5>
		<a href="<spring:url value='/projects/add'/>">Launch New Project</a>
	</h5>
</body>
</html>