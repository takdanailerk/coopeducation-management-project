<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
<head>
<meta charset="UTF-8">
<title>ระบบสหกิจศึกษา</title>
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
<%@include file="../navbar.jsp" %>
<div class="container">
    <h2>รายละเอียดการขอฝึกงาน</h2>
    <a href="${pageContext.request.contextPath}/faculty/list-coopeducation-page">-ย้อนกลับ </a>
     	<div class="form-group row mb-3"></div>
     	<div class="form-group row mb-3">
	         <div class="col-sm-4 control-label">ประเภทคำร้องขอ : ${coopEducation.coopName} </div>
	    </div>
	    <div class="form-group row mb-3">
	         <div class="col-sm-4 control-label">สาขาวิชา : ${coopEducation.major.majorName} </div>
	    </div>
	    <div class="form-group row mb-3">
	         <div class="col-sm-7 control-label">ชื่อสถานประกอบการ : ${coopEducation.company.companyName} </div>
	    </div>
	    <div class="form-group row mb-3">
	         <div class="col-sm-5 control-label">วันที่ไป : ${formattedStartDate} </div>
	         <div class="col-sm-5 control-label">วันที่กลับ : ${formattedEndDate} </div>
	    </div>
	    <div class="form-group row mb-3">
	         <div class="col-sm-9 control-label"></div>
	         <div class="col-sm-3 control-label text-right">
    			<a href="/faculty/generate-pdf" class="btn btn-primary" download="report.pdf">ดาวน์โหลดคำร้องขอ</a>
			</div>
			<form action="/faculty/generate-pdf" method="post">
        <button download="report.pdf">Download PDF</button>
    </form>
	    </div>
	<table border="1">
        <tr>
            <th>รหัสนักศึกษา</th>
            <th>ชื่อ-นามสกุล</th>
            <th>ไฟล์ cv/resume</th>
            <th>จัดการ</th>
            <th>สถานะ</th>
        </tr>
        <c:forEach var="acceptance" items="${acceptanceStatuses}">
        <tr>
            <td>${acceptance.student.studentId}</td>
            <td>${acceptance.student.studentName}</td>
            <td>
                <!-- ใช้ลูปซ้อนลูปเพื่อแสดงลิงค์ดาวน์โหลดสำหรับเอกสาร -->
                <c:forEach var="document" items="${acceptance.student.documents}">
                        <a href="${pageContext.request.contextPath}/download-document/${document.docId}">ดาวน์โหลด</a><br/>
                </c:forEach>
            </td>
            <td><a href="delete/${staff.staffId}">ลบ</a></td>
            <td>รอจัดส่งเอกสาร</td>
        </tr>
    	</c:forEach>
         
    </table>
    <div class="form-group row mb-3">
            
        </div>
</div>

<%@include file="../footer.jsp" %>
</body>
</html>

