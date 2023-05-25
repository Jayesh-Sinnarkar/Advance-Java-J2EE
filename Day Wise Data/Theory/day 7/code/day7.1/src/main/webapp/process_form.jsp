<%@page import="java.time.Period"%>
<%@page import="pojos.Student"%>
<%@page import="java.time.LocalDate"%>
<%@page import="pojos.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admission Processing Form</title>
</head>
<body>
<h4>From process form : Session ID : ${pageContext.session.id}</h4>
	<%
	//create student object : by reading , parsing rq params
	String firstName = request.getParameter("fn");
	String lastName = request.getParameter("ln");
	Course selectedCourse = Course.valueOf(request.getParameter("course").toUpperCase());
	int score = Integer.parseInt(request.getParameter("score"));
	LocalDate date = LocalDate.parse(request.getParameter("dob"));
	//firstName, String lastName, Course chosenCourse, int score, LocalDate dob) {
	Student student = new Student(firstName, lastName, selectedCourse, score, date);
	//validate age n score ,set admission sts .
	int ageInyrs = Period.between(date, LocalDate.now()).getYears();
	if (ageInyrs < 30 && score >= selectedCourse.getMinScore())
		student.setAdmissionStatus(true);
	//save student details under session scope (redirect : CP2)
	session.setAttribute("student_dtls", student);
	//redirect : To encode the redirect URL :
		//HttpServletResp : public String encodeRedirectURL(String origURL)
	response.sendRedirect(response.encodeRedirectURL("result.jsp"));
	%>
</body>
</html>