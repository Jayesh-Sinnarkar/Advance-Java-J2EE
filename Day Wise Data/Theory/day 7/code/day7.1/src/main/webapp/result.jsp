<%@page import="pojos.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admission Result Page</title>
</head>
<body>
<h4>From result page : Session ID : ${pageContext.session.id}</h4>
<%--session.getAttribute("student_dtls").getFirstName()  toString  : sent clnt browser --%>
	<h4>Hello ${sessionScope.student_dtls.firstName}
		${sessionScope.student_dtls.lastName}</h4>
	<%
	Student s = (Student) session.getAttribute("student_dtls");
	if (s.isAdmissionStatus()) {
	%>
	<h4>Congratulations !!!!! You are admitted in Course :
		${sessionScope.student_dtls.chosenCourse}</h4>
	<%
	} else {
	%>
	<h4>Sorry !!!!! You are not  admitted in Course :
		${sessionScope.student_dtls.chosenCourse}</h4>
	<%
	}
	%>
</body>
</html>