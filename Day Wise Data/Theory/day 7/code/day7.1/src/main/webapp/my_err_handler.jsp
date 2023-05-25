<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- Java Code pageContext.getException().getMessage() : sent to clnt  --%>
	<h4 style="color: red;">Error Message :
		${pageContext.exception.message}</h4>
	<h4 style="color: red;">Error causing page :
		${pageContext.errorData.requestURI}</h4>
	<h4 style="color: red;">Error Details : ${pageContext.exception}</h4>
</body>
</html>