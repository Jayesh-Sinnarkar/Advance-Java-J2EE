<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!
 //JSP declaration block
 private String mesg="some mesg!";//private instance var.

%>
<body>
<% 
String mesg2="another mesg";//method local var : within _jspService
pageContext.setAttribute("nm", 12345);//created page scoped attr.
%>
<%@ include file="test3.jsp"  %>
</body>
</html>