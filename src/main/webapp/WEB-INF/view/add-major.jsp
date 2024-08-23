<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<%@include file="navbar.jsp" %>
<form action="${pageContext.request.contextPath}/majors/add" method="post" class="form-horizontal">
    <div class="container">
        <div class="form-group row mb-3">
            <div class="col-sm-5 control-label ">เพิ่มข้อมูล สาขา .</div>
        </div>
        <div class="form-group row mb-3">
            <div class="col-sm-2 control-label">ชื่อสาขาาาา :</div>
            <div class="col-sm-3">
                <input type="text" name="majorName" required class="form-control" minlength="2" placeholder="ชื่อ สาขา">
            </div>
            <div class="col-sm-1 control-label">โทรศัพท์!!!! :</div>
            <div class="col-sm-3">
                <input type="text" name="majorPhoneNo" required class="form-control" minlength="2" placeholder="โทรศัพท์">
            </div>
        </div>
        <div class="form-group row mb-3" >
            <div class="col-sm-1 control-label">โทรสาร :</div>
            <div class="col-sm-3">
                <input type="text" name="majorFax" required class="form-control" minlength="2" placeholder="โทรสาร">
            </div>
            <div class="col-sm-1 control-label">อีเมล์ :</div>
            <div class="col-sm-3">
                <input type="email" name="majorEmail" required class="form-control" minlength="2" placeholder="อีเมล์">
            </div>
        </div>
		<div class="form-group row mb-3" >
			<div class="staff-field">
			<div class="col-sm-1 control-label">ชื่ออาจารย์ ผู้รับผิดชอบ:<span id="staffCountDisplay">${staffCount}</span></div>
		    <div class="col-sm-3">
		         <input type="text" name="staffName" required class="form-control" minlength="2" placeholder="ชื่ออาจารย์">
		    </div>
		    <div class="col-sm-1 control-label">นามสกุล :</div>
		    <div class="col-sm-3">
		         <input type="text" name="staffSurname" required class="form-control" minlength="2" placeholder="นามสกุล">
		    </div>
			</div>
		    <div id="staffContainer"></div>
		    
		</div>
		<div class="col-sm-3">
		    	<button type="button" onclick="addStaffField()">เพิ่มอาจารย์</button>
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
<%@include file="footer.jsp" %>
</body>

	
	<script>
	
	let staffCount = 1;
	
        function addStaffField() {
        	
        	staffCount++;
        	console.log("After increment:", staffCount);
        	
        	document.getElementById('staffCountDisplay').innerText = staffCount;
        	
            const staffContainer = document.getElementById('staffContainer');
            const newStaffField = document.createElement('div');
            newStaffField.className = 'staff-field';
            newStaffField.innerHTML = `
                <label>Staff Name ${staffCount}:</label>
                <input type="text" name="staffName[]" required>
                <label>Staff Surname ${staffCount}:</label>
                <input type="text" name="staffSurname[]" required>
                <button type="button" onclick="removeStaffField(this)">Remove</button>
                <br><br>
            `;
            staffContainer.appendChild(newStaffField);
            
        }

        function removeStaffField(button) {
            const staffField = button.parentElement;
            staffField.remove();
            staffCount--;
            document.getElementById('staffCountDisplay').innerText = staffCount;
            
            const labels = document.querySelectorAll('.staff-field label:first-child');
            labels.forEach((label, index) => {
                label.innerText = `Staff Name ${index + 1}:`;
            });
        }
        console.log("After calling addStaffField");
        
        
    </script>
    

</html>