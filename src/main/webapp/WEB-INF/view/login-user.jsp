<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<form action="${pageContext.request.contextPath}/login-user" method="post" class="form-horizontal">
    <div class="container">
		<div class="form-group row mb-3" >
			<div class="staff-field">
			<div class="col-sm-1 control-label">ชื่อผู้ใช้:</div>
		    <div class="col-sm-3">
		         <input type="text" name="suername" id="suername" required class="form-control" minlength="2" placeholder="mju6300000000@mju.ac.th">
		    </div>
		    <div class="col-sm-1 control-label">รหัสผ่าน :</div>
		    <div class="col-sm-3">
		         <input type="text" name="password" id="password" required class="form-control" minlength="2" placeholder="mju@00000000">
		    </div>
			</div>
		   
		</div>
        <div class="form-group row mb-3">
            <div class="col-sm-2">
            </div>
            <div class="col-sm-3">
                <button type="submit" class="btn btn-primary">บันทึก</button>
            </div>
        </div>

    </div>
</form>
</body>

</html>