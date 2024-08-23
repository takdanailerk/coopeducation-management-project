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

<form:form modelAttribute="staff" action="${pageContext.request.contextPath}/majors/update/${staff.staffId}" method="post">
    <div class="container ">
        <div class="form-group row mb-3">
            <h2>Edit Major</h2>
        </div>
       <div class="form-group row mb-3">
            <div class="col-sm-2 control-label">ชื่อสาขา :</div>
            <div class="col-sm-3">
                <form:input path="major.majorName"/>
            </div>
            <div class="col-sm-1 control-label">เบอร์โทรศัพท์ :</div>
            <div class="col-sm-3">
                <form:input path="major.majorPhoneNo"/>
            </div>
        </div>
        <div class="form-group row mb-3">
            <div class="col-sm-2 control-label">เบอร์โทรสาร :</div>
            <div class="col-sm-3">
                <form:input path="major.majorFax"/>
            </div>
            <div class="col-sm-1 control-label">อีเมล์ :</div>
            <div class="col-sm-3">
                <form:input path="major.majorEmail"/>
            </div>
        </div>
        <div class="form-group row mb-3">
            <div class="col-sm-2 control-label">ชื่ออาจารย์ ผู้รับผิดชอบ :</div>
            <div class="col-sm-3">
                <form:input path="staffName"/>
            </div>
            <div class="col-sm-1 control-label">นามสกุล :</div>
            <div class="col-sm-3">
                <form:input path="staffSurname"/>
            </div>
        </div>
        <div class="form-group row mb-3">
            <div class="col-sm-3">
                <button type="submit" value="update">บันทึก</button>
            </div>
        </div>
    </div>

</form:form>
<%@include file="footer.jsp" %>
</body>
</html>