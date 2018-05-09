<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
</head>
<body>
	<p>Username: <b><sec:authentication property="principal.username"/></b></p>
	<c:url value="/showMessage.html" var="messageUrl" />
	<a href="./admin">Admin</a>

	<form action="logout" method="post">
		<input type="submit" value="Logout" /> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
</body>
</html>
