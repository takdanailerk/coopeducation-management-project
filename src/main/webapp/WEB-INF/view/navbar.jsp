<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>ระบบสหกิจ</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="http://localhost:35729/livereload.js"></script>
</head>
<body>

<div class="container-fluid p-5 bg-success text-center">
    <h1 class="text-white" >ระบบสหกิจศึกษาคณะวิทยาศาสตร์ มหาวิทยาลัยแม่โจ้</h1>
</div>
<div class="container-fluid bg-dark">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
        <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
                <ul class="navbar-nav ">
                    <li class="nav-item ">
                        <a class="nav-link text-white" href="${pageContext.request.contextPath}/">หน้าหลัก</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-white col-sm-3" href="#" role="button" data-bs-toggle="dropdown">แบบฟอร์มคำร้องขอ</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item col-sm-2" href="request-form">ขอความอนุเคราะห์</a></li>
                            <li><a class="dropdown-item col-sm-2" href="referral-form">ขอส่งตัวนักศึกษา</a></li>
                        </ul>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-white" href="#" role="button" data-bs-toggle="dropdown">รายการคำร้องขอ</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="list-request-form">รายการขอความอนุเคราะห์</a></li>
                            <li><a class="dropdown-item" href="list-referral-form">รายการขอส่งตัวนักศึกษา</a></li>
                        </ul>
                    </li>
                    <li class="nav-item"> <a class="nav-link text-white" href="view-status">ดูสถานะ</a></li>
                    <li class="nav-item"> <a class="nav-link text-white" href="logout">ออกจากระบบ</a></li>
                    <li class="nav-item"> <a class="nav-link text-white" href="${pageContext.request.contextPath}/majors/add-major-page">เพิ่มสาขา</a></li>
                    <li class="nav-item"> <a class="nav-link text-white" href="${pageContext.request.contextPath}/majors/list-majors-page">รายชื่อสาขา</a></li>
<%--                    <li class="nav-item"> <a class="nav-link text-white" href="add-major-form">เพิ่มสาขา</a></li>--%>

                </ul>
        </div>
    </nav>
</div>

<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>--%>


<%--<div class="container-fluid mt-3">--%>
<%--    <h3>Navbar With Dropdown</h3>--%>
<%--    <p>This example adds a dropdown menu in the navbar.</p>--%>
<%--</div>--%>
<%--    <h1>Hi From Me!</h1>--%>

</body>
</html>