<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>From 1st page ....</h4>
	<h5>Product Name : ${param.name}</h5>
	<%--store product details in a req scoped attr --%>
	<%
	out.flush(); 
	request.setAttribute("product_dtls", request.getParameter("name") +"@"+request.getParameter("price"));
	%>
	<%--include : action the clnt to the next page , in the SAME request --%>
	<jsp:include page="test7.jsp">
		<jsp:param value="Food" name="category" />
	</jsp:include>
	<h5>contents post include ....</h5>
</body>
</html>