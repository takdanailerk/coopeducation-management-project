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
<div class="container">
    <h2>รายการขอความอนุเคราะห์/ขอส่งตัวนักศึกษา</h2>
    <a href="${pageContext.request.contextPath}/request-form/add-request-form-page">ไปยังหน้า กรอกแบบฟอร์ม</a>
    <table border="1">
        <tr>
            <th>ลำดับที่</th>
            <th>คำร้องขอ</th>
            <th>ประเภทการปฎิบัติงาน</th>
            <th>สาขา</th>
<%--            <th>รายชื่อนักศึกษา</th>--%>
            <th>ชื่อสถานประกอบการ</th>
            <th>จัดการ</th>
        </tr>
        <c:forEach var="acceptance" items="${acceptance_status}">
            <tr>
                <td>${acceptance.acceptStatId}</td>
                <td>${acceptance.coopEducation.coopName}</td>
                <td>${acceptance.coopEducation.coopEduType}</td>
                <td>${acceptance.coopEducation.major.majorName}</td>
<%--                <td>${coop_education.Student.studentName}</td>--%>
                <td>${acceptance.coopEducation.company.companyName}</td>
                <td>
                    <a href="edit-request-page/${acceptance.acceptStatId}">แก้ไข</a>
                    <a href="delete/${acceptance.acceptStatId}">ลบ</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class="form-group row mb-3">
            
        </div>
</div>


<%@include file="footer.jsp" %>
</body>
</html>