<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%--import JSTL supplied core tag lib --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--import spring supplied JSP tag lib --%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--url : URL rewriting n making URIs relative to current ctx path --%>
<spring:url var="abc" value="/emp/list"/>
	<form action="${abc}" method="get">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Choose Department</td>
				<td><select name="selectedDept">
						<c:forEach var="dept" items="${requestScope.depts}">
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