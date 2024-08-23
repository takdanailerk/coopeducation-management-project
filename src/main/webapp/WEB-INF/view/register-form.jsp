<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<%@include file="navbar.jsp" %>
<form action="${pageContext.request.contextPath}/staffs/register-form" method="post" class="form-horizontal" >
        <div class="container">
        <div>
    		<h1>ลงทะเบียสำหรับอาจารย์ ประจำสาขา</h1>
    	</div>
        
		<div class="form-group row mb-3" >
			<div class="staff-field">
			<div class="col-sm-3 control-label">ชื่ออาจารย์ผู้รับผิดชอบ:</div>
		    <div class="col-sm-3">
		         <input type="text" name="staffName" th:field="*{staffName} required class="form-control" minlength="2" placeholder="ชื่ออาจารย์">
		    </div>
		    <div class="col-sm-1 control-label">นามสกุล :</div>
		    <div class="col-sm-3">
		         <input type="text" name="staffSurname" th:field="*{staffSurname} required class="form-control" minlength="2" placeholder="นามสกุล">
		    </div>
		    <div class="col-sm-3 control-label">ชื่ออาจารย์ผู้รับผิดชอบ:</div>
		    <div class="col-sm-3">
		         <input type="text" name="staffPhoneNo" th:field="*{staffPhoneNo} required class="form-control" minlength="2" placeholder="ชื่ออาจารย์">
		    </div>
		    <div class="col-sm-1 control-label">นามสกุล :</div>
		    <div class="col-sm-3">
		         <input type="text" name="staffEmail" th:field="*{staffEmail} required class="form-control" minlength="2" placeholder="นามสกุล">
		    </div>
		    <div class="col-sm-3 control-label">ชื่อผู้ใช้ username:</div>
		    <div class="col-sm-3">
		         <input type="text" name="username" th:field="*{username}" required class="form-control" minlength="2" placeholder="mju6300000000@mju.ac.th">
		    </div>
			<div class="col-sm-3 control-label">รหัส password:</div>
		    <div class="col-sm-3">
		         <input type="text" name="password" th:field="*{password}" required class="form-control" minlength="2" placeholder="mju@00000000">
		    </div>
			</div>
			
			</div>
			
		    
			<div class="form-group row mb-3">
            <div class="col-sm-2"></div>
            <div class="col-sm-3">
                <button type="submit" class="btn btn-primary">ลงทะเบียน</button>
            </div>
        </div>
		</div>

    </div>
</form>
<%@include file="footer.jsp" %>
</body>

</html>