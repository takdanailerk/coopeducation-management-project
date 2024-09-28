<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Title</title>
    
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

<form:form modelAttribute="coopEducation" action="${pageContext.request.contextPath}/request-form/update/${coopEducation.coopEduId}" method="post">
    <div class="container ">
    <h2>รายละเอียดการขอฝึกงาน</h2>
    <a href="${pageContext.request.contextPath}/request-form/list-request-page">-ย้อนกลับ </a>
     	<div class="form-group row mb-3"></div>
     	<div class="form-group row mb-3">
	         <div class="col-sm-4 control-label">ประเภทคำร้องขอ : <form:input path="coopName"/> </div>
	    </div>
	    <div class="form-group row mb-3">
	         <div class="col-sm-4 control-label">สาขาวิชา : ${coopEducation.major.majorName} </div>
	    </div>
	    <div class="form-group row mb-3">
	         <div class="col-sm-7 control-label">ชื่อสถานประกอบการ :  <form:input path="company.companyName"/> </div>
	         <div class="col-sm-7 control-label">ที่อยู่ :  <form:input path="company.companyAddress"/> </div>
	         <div class="col-sm-7 control-label">เบอร์โทร :  <form:input path="company.companyPhoneNo"/> </div>
	         <div class="col-sm-7 control-label">อีเมล์ :  <form:input path="company.companyEmail"/> </div>
	         <div class="col-sm-7 control-label">ไลน์ :  <form:input path="company.companyLine"/> </div>
	         <div class="col-sm-7 control-label">เฟสบุ๊ก :  <form:input path="company.companyFacebook"/> </div>
	         <div class="col-sm-7 control-label">ชื่อผู้ประสานงาน :  <form:input path="company.coordinatorName"/> </div>
	         <div class="col-sm-7 control-label">เบอร์โทร :  <form:input path="company.coordinatorPhoneNo"/> </div>
	    </div>
	    <div class="form-group row mb-3">
	         <div class="col-sm-5 control-label">วันที่ไป : ${formattedStartDate} </div>
	         <div class="col-sm-5 control-label">วันที่กลับ : ${formattedEndDate} </div>
	    </div>
	<table border="1">
        <tr>
            <th>รหัสนักศึกษา</th>
            <th>ชื่อ-นามสกุล</th>
            <th>ไฟล์ cv/resume</th>
            <th>สถานะ</th>
            <th>จัดการ</th>
        </tr>
        <c:forEach var="acceptance" items="${acceptanceStatuses}">
        <tr>
            <td>${acceptance.student.studentId}</td>
            <td>${acceptance.student.studentName}  ${acceptance.student.studentLastname}</td>
            <td>
                        <!-- ใช้ลูปซ้อนลูปเพื่อแสดงลิงค์ดาวน์โหลดสำหรับเอกสาร -->
                        <c:forEach var="filePath" items="${studentDocuments[acceptance.student.studentId]}">
                            <a href="${pageContext.request.contextPath}/download/${filePath}" target="_blank">${filePath}</a><br/>
                        </c:forEach>
                    </td>
            <td>รอจัดส่งเอกสาร</td>
            <td>
             	<a href="${pageContext.request.contextPath}${acceptance.coopEducation.coopEduId}/edit-student-page/${acceptance.student.studentId}">แก้ไข</a>
            	<a href="delete/${acceptance.student.studentId}">ลบ</a>
            </td>
        </tr>
    	</c:forEach>
         
    </table>
    	<div class="form-group row mb-3"></div>
        <div class="form-group row mb-3">
        <div class="col-sm-5"></div>
            <div class="col-sm-1">
                <button type="submit" class="btn btn-secondary danger" value="update">บันทึก</button>
            </div>
            <div class="col-sm-3">
                <button type="button" class="btn btn-danger" onclick="window.location.href='/request-form/list-request-page';">ยกเลิก</button>
            </div>
        </div>
        <div class="form-group row mb-3">
            
        </div>
    </div>

</form:form>
<%@include file="footer.jsp" %>
</body>
</html>