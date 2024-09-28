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

<form:form modelAttribute="acceptances" action="${pageContext.request.contextPath}/request-form/edit-request-page/${acceptances.coopEducation.coopEduId}/edit-student-page/update/${acceptances.student.studentId}" method="post">
    <div class="container ">
        <div class="form-group row mb-3">
            <h2>แก้ไข ข้อมูลนักศึกษา</h2>
        </div>
       <div class="form-group row mb-3">
            <div class="col-sm-1 control-label">ชื่อ :</div>
            <div class="col-sm-3" >
                <form:input path="student.studentName"/>
            </div>
            <div class="col-sm-1 control-label">นามสกุล :</div>
            <div class="col-sm-3">
                <form:input path="student.studentLastname"/>
            </div>
        </div>
        <div class="form-group row mb-3">
        <div class="col-sm-1 control-label">รหัสนักศึกษา :</div>
            <div class="col-sm-3">
                <form:input path="student.studentId"/>
            </div>
            <div class="col-sm-1 control-label">เบอร์โทร :</div>
            <div class="col-sm-3">
                <form:input path="student.studentPhoneNo"/>
            </div>
            
        </div>
        <div class="form-group row mb-3">
            <div class="col-sm-1 control-label">อีเมล์ :</div>
            <div class="col-sm-3">
                <form:input path="student.studentEmail"/>
            </div>
        </div>
        
        <div class="form-group row mb-3">
        	
            <div class="col-sm-1">
                <button type="submit" class="btn btn-secondary value="update">บันทึก</button>
            </div>
            <div class="col-sm-3">
                <button type="button" class="btn btn-danger" onclick="window.location.href='/request-form/edit-request-page/${acceptances.coopEducation.coopEduId}';">ยกเลิก</button>
            </div>
        </div>
    </div>

</form:form>
<%@include file="footer.jsp" %>
</body>
</html>