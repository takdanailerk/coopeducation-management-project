<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="container">
    <h2>รายการ สาขา คณะวิทยาศาสตร์</h2>
    <table border="1">
        <tr>
            <th>ลำดับที่</th>
            <th>ชื่อ สาขา</th>
            <th>เบอร์โทรศัพท์</th>
            <th>โทรสาร</th>
            <th>อีเมล์</th>
            <th>แก้ไข/ลบ</th>
        </tr>
        <c:forEach var="major" items="${majors}">
            <tr>
                <td>${major.majorId}</td>
                <td>${major.majorName}</td>
                <td>${major.majorPhoneNo}</td>
                <td>${major.majorFax}</td>
                <td>${major.majorEmail}</td>
                <td>
                    <a href="update-major-page/${major.majorId}">แก้ไข</a>
                    <a href="delete/${major.majorId}">ลบ</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="add-major-page" >กลับไปหน้า ฟอร์มสาขา</a>
</div>
<%@include file="footer.jsp" %>
</body>
</html>