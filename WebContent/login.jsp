<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<link rel="stylesheet" href="resources/css/login.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">

<script type="text/javascript" src="resources/js/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/login.js"></script>

</head>
<body>

	<%
		Cookie[] cookies = request.getCookies();

		for (Cookie c : cookies) {
			if (c.getName().equals("uname")) {
				request.setAttribute("username", c.getValue());
			} else if (c.getName().equals("pass")) {
				request.setAttribute("password", c.getValue());
			}
		}
	%>

	<div class="card card-container">
		<img id="profile-img" class="profile-img-card"
			src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
		<p id="profile-name" class="profile-name-card"></p>
		<form class="form-signin" action="LoginController" method="post">
			<span style="color: red">${loginFail}</span> <span
				style="color: blue">${loggedOut}</span> <span id="reauth-email"
				class="reauth-email"></span> <input type="text" id="inputEmail"
				class="form-control" name="uname" value="${username}"> <input
				type="password" id="inputPassword" class="form-control" name="pass"
				value="${password}">
			<div id="remember" class="checkbox">
				<label> <input type="checkbox" name="remember-me"
					value="remember-me"> Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block btn-signin"
				type="submit">Sign in</button>
		</form>
		<!-- /form -->
		<a href="#" class="forgot-password"> Forgot the password? </a>
	</div>