<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

	<%
		Cookie[] cookies= request.getCookies();
		
		for(Cookie c : cookies){
			if(c.getName().equals("uname")){
				request.setAttribute("username", c.getValue());
			}else if(c.getName().equals("pass")){
				request.setAttribute("password", c.getValue());
			}
		}
	%>

	<div>
		<form action="LoginController" method="post">
			<span style="color: red">${loginFail}</span>
			<span style="color: blue">${loggedOut}</span>
			<div>
				<label>Username</label> <input type="text" name="uname" value="${username}">
			</div>
			<div>
				<label>Password</label> <input type="password" name="pass" value="${password}">
			</div>
			<div>
				<input type="checkbox" name="remember-me">Remember-Me
			</div>
			<div>
				<input type="submit" value="submit">
			</div>
		</form>
	</div>
</body>
</html>