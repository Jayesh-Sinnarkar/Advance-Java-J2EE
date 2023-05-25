<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4 align="center">Session ID : ${pageContext.session.id}</h4>
<h5>${sessionScope.user.validatedUserDetails.firstName} have successfully logged out!</h5>
<%-- discard session --%>
${pageContext.session.invalidate()}
</body>
</html>