<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Process Form</title>

<jsp:useBean id="user" class="beans.UserBean" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>

</head>
<body>
<h3> Routing status : ${sessionScope.user.registerVoter()}</h3>
</body>
</html>