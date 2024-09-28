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
	<% String role = (String) session.getAttribute("role"); %>
	<h1>hi!</h1>
	<p>Welcome, <%= session.getAttribute("loggedInUser") %>!</p>
	<c:forEach var="staff" items="${staffs}">
		<h2>${staff.username}</h2>
		<h4>${staff.password}</h4>
	</c:forEach>
	
	<% if ("ADMIN".equals(role)) { %>
    <p>You have admin privileges.</p>
    <!-- เนื้อหาสำหรับผู้ที่มี role เป็น ADMIN -->
	<% } else if ("USER".equals(role)) { %>
    <p>You have user privileges.</p>
    <!-- เนื้อหาสำหรับผู้ที่มี role เป็น USER -->
	<% } %>
	
	<%@include file="footer.jsp" %>
</body>
</html>