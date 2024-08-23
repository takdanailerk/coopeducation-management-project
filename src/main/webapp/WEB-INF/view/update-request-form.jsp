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

<form:form modelAttribute="acceptance" action="${pageContext.request.contextPath}/request-form/update/${acceptance.acceptStatId}" method="post">
    <div class="container ">
        <div class="form-group row mb-3">
            <h2>แก้ไขข้อมูล</h2>
        </div>
       <div class="form-group row mb-3">
            <div class="col-sm-2 control-label">ชื่อสาขา :</div>
            <div class="col-sm-3">
                <form:input path="acceptStatus"/>
            </div>
            <div class="col-sm-2 control-label">ชื่อสาขา :</div>
            <div class="col-sm-3">
                <form:input path="coopEducation.coopName"/>
                <span>${acceptance.coopEducation.coopName}</span>
            </div>
        </div>
        <div class="form-group row mb-3">
            <div class="col-sm-3">
                <button type="submit" value="update">บันทึก</button>
            </div>
        </div>
        <div class="form-group row mb-3">
            <div class="col-sm-3">
                <button type="button" class="btn btn-secondary danger" onclick="window.location.href='/request-form/add-request-form-page';">ยกเลิก</button>
            </div>
        </div>
    </div>

</form:form>
<%@include file="footer.jsp" %>
</body>
</html>