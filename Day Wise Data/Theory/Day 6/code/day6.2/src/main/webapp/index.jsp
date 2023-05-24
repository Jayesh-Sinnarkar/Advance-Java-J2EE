<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">Session ID : <%= session.getId() %></h3>
	<h4>
		Welcome 2 JSP @
		<%=LocalDateTime.now()%></h4>
	<h5>
		<a href="comments.jsp">Test Comments</a>
	</h5>
	<h5>
		<a href="login.jsp">Test Scriptlets n Expressions</a>
	</h5>
	<h5>
		<a href="login2.jsp">Testing all  Scripting elements n EL Syntax</a>
	</h5>
	
</body>
</html>