<%@page import="java.time.LocalDate"%>
<%@page import="pojos.User"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!//JSP declaration block
	HashMap<String, User> users;

	public void jspInit() {
		users = new HashMap<>();
		//add 2 users
		//name, String email, String password, LocalDate dob, double regAmount
		users.put("abc@gmail.com", new User("abc", "abc@gmail.com", "12345", LocalDate.parse("2000-12-20"), 5678));
		users.put("xyz@gmail.com", new User("xyz", "xyz@gmail.com", "2345", LocalDate.parse("1997-12-20"), 5778));

	}%>
<body>

</body>
</html>