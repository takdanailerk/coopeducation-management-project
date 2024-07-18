<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container">
    <h2>List of Majors</h2>
    <table border="1">
        <tr>
            <th>Major ID</th>
            <th>Major Name</th>
            <th>Phone No</th>
            <th>Fax</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>
    <c:forEach var="major" items="${majors}">
        <tr>
            <td>${major.majorId}</td>
            <td>${major.majorName}</td>
            <td>${major.majorPhoneNo}</td>
            <td>${major.majorFax}</td>
            <td>${major.majorEmail}</td>
            <td>
                <a href="${pageContext.request.contextPath}/majors/update-major-page/${major.majorId}">Edit</a>
                <a href="${pageContext.request.contextPath}/majors/delete/${major.majorId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/majors/add-major-page">Add New Major</a>

</div>
<%@include file="footer.jsp" %>
</body>
</html>