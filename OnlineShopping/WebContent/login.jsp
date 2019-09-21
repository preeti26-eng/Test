<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style><%@include file="/WEB-INF/css/project.css"%></style>
	<title>Login Page</title>
</head>
<body>
	<form:form action="doLogin.obj" modelAttribute="login">
		<table id="logintable">
  			<tr><td>User Name</td>
  			<td><form:input path="uname" type="text" value=""/></td></tr>
  			<tr><td>Password</td>
  			<td><form:input path="pwd" type="password" value=""/></td></tr>
  		</table>
  		<br><br>
  		<input class="butt" type="submit" value="Submit" />
  	</form:form>	
</body>
</html>