<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <!-- เพิ่มการเชื่อมโยง CSS ของคุณที่นี่ -->
    <title>ล็อกอิน</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="http://localhost:35729/livereload.js"></script>
</head>
<body>
    <form action="${pageContext.request.contextPath}/authenticate" method="post" class="form-horizontal">
        <div class="container">
        	<div class="form-group row mb-3"></div>
        	<div class="form-group row mb-3"></div>
        	<div class="form-group row mb-3"></div>
        	<div class="form-group row mb-3"></div>
            <div class="form-group row mb-3">
            <div class="col-sm-3"></div>
                <div class="col-sm-1 control-label">
                    <label for="username">ชื่อผู้ใช้:</label>
                </div>
                <div class="col-sm-3">
                    <input type="text" name="username" id="username" required class="form-control" minlength="2" placeholder="mju6300000000@mju.ac.th">
                </div>
            </div>
            <div class="form-group row mb-3">
            <div class="col-sm-3"></div>
        		<div class="col-sm-1 control-label">
                    <label for="password">รหัสผ่าน:</label>
                </div>
                <div class="col-sm-3">
                    <input type="password" name="password" id="password" required class="form-control" minlength="2" placeholder="mju@00000000">
                </div>
            </div>
            <div class="form-group row mb-3">
                <div class="col-sm-5"></div>
                <div class="col-sm-3">
                    <button type="submit" class="btn btn-primary">เข้าสู่ระบบ</button>
                </div>
                <div th:if="${error}" th:text="${error}"></div>
            </div>
            
        </div>
    </form>
</body>
</html>