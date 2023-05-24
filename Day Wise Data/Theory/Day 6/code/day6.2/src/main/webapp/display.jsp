<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">
		Session ID :
		<%=session.getId()%></h3>
	<h4>Displaying request params using scriptlet</h4>
	<%
	//java code : scriptlet
	out.print("<h4>Email " + request.getParameter("em") + "</h4>");
	out.print("<h4>Password " + request.getParameter("pass") + "</h4>");
	%>
	<hr />
	<h4>Displaying request params using scriptlet again</h4>
	<h4>
		Email :
		<%
	//java code : scriptlet
	out.print(request.getParameter("em"));
	%>
	</h4>
	<h4>
		Password :
		<%
	//java code : scriptlet
	out.print(request.getParameter("pass"));
	%>
	</h4>
	<hr />
	<h3>Display clnt details using JSP Expression</h3>
	<h5>
		Email :
		<%=request.getParameter("em")%></h5>
	<h5>
		Password :
		<%=request.getParameter("pass")%></h5>
	<hr />
	<h3>Display clnt details using EL syntax</h3>
	<h4>param  : ${param}</h4>
	<h5> Email : ${param.em}</h5>
	<h5> Password : ${param.pass}</h5>
</body>
</html>