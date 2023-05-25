<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
</head>
<body>
<form action="process_form.jsp" method="post">
<table>
<tr>
<td>First Name:</td>
<td><input type="text" name="firstName"></input></td>
</tr>

<tr>
<td>Last Name:</td>
<td><input type="text" name="lastName"></input></td>
</tr>

<tr>
<td>Email:</td>
<td><input type="email" name="emailId"></input></td>
</tr>

<tr>
<td>Password:</td>
<td><input type="password" name="passowrd"></input></td>
</tr>

<tr>
<td>Date of birth:</td>
<td><input type="date" name="dob"></input></td>
</tr>

<tr>
<td colspan="2" align="center"><input type="submit" value="Register"></input></td>
</tr>

</table>
</form>

</body>
</html>