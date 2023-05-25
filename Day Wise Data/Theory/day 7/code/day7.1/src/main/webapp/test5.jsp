<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>From 2nd page ....</h4>
	<h5>Product Name : ${param.name}</h5>
	<h5>Product Category : ${param.category}</h5>
	<%-- display product details--%>
<h5>Product Details from request scope : ${requestScope.product_dtls}</h5>
</body>
</html>