<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="navbar.jsp" %>
	<h1>hi!</h1>
	<c:forEach var="staff" items="${staffs}">
		<h2>${staff.username}</h2>
		<h4>${staff.password}</h4>
	</c:forEach>
	<%@include file="footer.jsp" %>
</body>
</html>