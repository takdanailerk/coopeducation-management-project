<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="navbar.jsp" %>

<form:form modelAttribute="major" action="${pageContext.request.contextPath}/majors/update/${major.majorId}" method="post">
    <div class="container ">
        <div class="form-group row mb-3">
            <h2>Edit Major</h2>
        </div>
       <div class="form-group row mb-3">
            <div class="col-sm-2 control-label">ชื่อสาขา :</div>
            <div class="col-sm-3" >
                <form:input path="majorName"/>
            </div>
            <div class="col-sm-1 control-label">เบอร์โทรศัพท์ :</div>
            <div class="col-sm-3">
                <form:input path="majorPhoneNo"/>
            </div>
        </div>
        <div class="form-group row mb-3">
            <div class="col-sm-2 control-label">โทรสาร :</div>
            <div class="col-sm-3">
                <form:input path="majorFax"/>
            </div>
            <div class="col-sm-1 control-label">อีเมล์ :</div>
            <div class="col-sm-3">
                <form:input path="majorEmail"/>
            </div>
        </div>
        <div class="form-group row mb-3">
        	<div class="col-sm-5"></div>
            <div class="col-sm-1">
                <button type="submit" class="btn btn-secondary value="update">บันทึก</button>
            </div>
            <div class="col-sm-3">
                <button type="button" class="btn btn-danger" onclick="window.location.href='/majors/list-major-page';">ยกเลิก</button>
            </div>
        </div>
    </div>

</form:form>
<%@include file="footer.jsp" %>
</body>
</html>