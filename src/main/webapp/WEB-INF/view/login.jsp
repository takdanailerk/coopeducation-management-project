<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <!-- เพิ่มการเชื่อมโยง CSS ของคุณที่นี่ -->
</head>
<body>
    <form action="${pageContext.request.contextPath}/api/login" method="post" class="form-horizontal">
        <div class="container">
            <div class="form-group row mb-3">
                <div class="col-sm-1 control-label">
                    <label for="username">ชื่อผู้ใช้:</label>
                </div>
                <div class="col-sm-3">
                    <input type="text" name="username" id="username" required class="form-control" minlength="2" placeholder="mju6300000000@mju.ac.th">
                </div>
                <div class="col-sm-1 control-label">
                    <label for="password">รหัสผ่าน:</label>
                </div>
                <div class="col-sm-3">
                    <input type="password" name="password" id="password" required class="form-control" minlength="2" placeholder="mju@00000000">
                </div>
            </div>
            <div class="form-group row mb-3">
                <div class="col-sm-2"></div>
                <div class="col-sm-3">
                    <button type="submit" class="btn btn-primary">เข้าสู่ระบบ</button>
                </div>
            </div>
        </div>
    </form>
</body>
</html>