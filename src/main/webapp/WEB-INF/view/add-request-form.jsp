<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>
	<%@include file="navbar.jsp" %>
	<form id="add-request-form" action="${pageContext.request.contextPath}/request-form/add" method="post" class="form-horizontal" enctype="multipart/form-data">
	<div class="container ">
	        <div class="row">
	            <div class="col-md-12">
	                <div class="alert alert-danger" role="alert" >
	                    <h2 name="coopName" value="ขอความอนุเคราะห์">ฟอร์มขอความอนุเคราะห์ฝึกงานและสหกิจศึกษา </h2>
	                </div>
	            </div>
	        </div>
	        <div class="form-group row mb-3">
	            <div class="col-sm-5 control-label text-danger">*ยังไม่มีใบตอบรับจากสถานประกอบการให้กรอกฟอร์มนี้*</div>
	        </div>
	        <div class="form-group row mb-3">
	            <div class="col-sm-4 control-label">หลักสูตร : วิทยาศาสตร์ บัณฑิต </div>
	        </div>

	        <div class="form-group row mb-3">
	            <div class="col-sm-2 control-label">
	                สาขาวิชา :
	            </div>
	            <div class="col-sm-3">
                <select name="majorId"  class="form-select">
                    <c:forEach var="major" items="${majors}">
                        <option value="${major.majorId}">
                                ${major.majorName}
                        </option>
                    </c:forEach>
                </select>
            	</div>
	        </div>

	        <div class="form-group row mb-3">
	            <div class="col-sm-2 control-label">
	                ประเภทการปฎิบัติงาน :
	            </div>
	            <div class="form-check col-sm-1">
	                <input class="form-check-input" type="radio" name="coopEduType" id="flexRadio1" value="ฝึกงาน" path="coopEduType" checked>
	                <label class="form-check-label" for="flexRadio1">ฝึกงาน</label>
	            </div>
	            <div class="form-check col-sm-2">
	                <input class="form-check-input" type="radio" name="coopEduType" id="flexRadio2" path="coopEduType" value="สหกิจศึกษา" >
	                <label class="form-check-label" for="flexRadio2">สหกิจศึกษา</label>
	            </div>
	            <div class="col-sm-1 control-label">
	                ปีการศึกษา :
	            </div>
	            <div class="col-sm-1">
	                 <select name="coopEduYear" id="coopEduYear" class="form-select" required>
            			<!-- Options will be added here by JavaScript -->
        			 </select>
        			 
	            </div>
	            
	            <div class="col-sm-1 control-label">
	                ถาคเรียนที่ :
	            </div>
	            <div class="col-sm-1">
	                <select name="coopEduSemester" id="coopEduSemester" class="form-select" required>
	                    <option value="1">1</option>
	                    <option value="2">2</option>
	                </select>
	            </div>
	        </div>
	        <div class="form-group row mb-3">
	            <div class="col-sm-2 control-label">ระยะเวลาตั้งแต่วันที่เริ่ม</div>
	            <div class="col-sm-2">
	                <input type="date" name="startDate" id="startDate" date-provide="datepicker" min="" required class="form-control"  placeholder="เลือกวันที่" >
	            </div>
	            <div class="col-sm-1 control-label">ถึงวันที่กลับ</div>
	            <div class="col-sm-2">
	                <input type="date" name="endDate" id="endDate" date-provide=" datepicker"  min="" max=""  required class="form-control" placeholder="เลือกวันที่">
	            	<p id="warningMessage" style="color: red; display: none;">กรุณาเลือกวันที่ใหม่: วันที่ต้องไม่เกิน 6 เดือนจากฟิลด์แรก</p>
	            </div>
	        </div>

	        <div class="form-group row mb-3">
	            <div class="col-sm-5 control-label ">ข้อมูลสถานประกอบการ.</div>
	        </div>
	        <div class="form-group row mb-3">
	            <div class="col-sm-1 control-label">ชื่อ :</div>
	            <div class="col-sm-3">
	                <input type="text" name="companyName" id="companyName" required class="form-control" minlength="2" 
	                		placeholder="ชื่อสถานประกอบการ" list="companyList" oninput="updateCompanyId()">
	            	 <datalist id="companyList">
        				<c:forEach var="company" items="${companies}">
            				<option value="${company.companyName}" 
            				data-id="${company.companyId}"
            				data-address="${company.companyAddress}"
                    		data-phone="${company.companyPhoneNo}"
                    		data-email="${company.companyEmail}"
                    		data-line="${company.companyLine}"
                    		data-facebook="${company.companyFacebook}"
                    		data-cdtname="${company.coordinatorName}"
                    		data-cdtphone="${company.coordinatorPhoneNo}"></option>
        				</c:forEach>
    				</datalist>
    				<input type="hidden" id="companyId" name="companyId" >
	            </div>
	        	<div class="col-sm-1 control-label">ที่อยู่ :</div>
            	<div class="col-sm-3">
                	<textarea type="text" name="companyAddress" id="companyAddress" required class="form-control" minlength="2" placeholder="ที่อยู่"></textarea>
            	</div>
	        </div>
	        <div class="form-group row mb-3">
	            <div class="col-sm-1 control-label">เบอร์โทร :</div>
	            <div class="col-sm-3">
	                <input type="text" name="companyPhoneNo" id="companyPhoneNo" required class="form-control" minlength="2" placeholder="เบอร์โทร" >
	            </div>
	            <div class="col-sm-1 control-label">อีเมล์ :</div>
	            <div class="col-sm-3">
	                <input type="email" name="companyEmail" id="companyEmail" required class="form-control" minlength="2" placeholder="อีเมล์" >
	            </div>
	        </div>
	        <div class="form-group row mb-3">
	            <div class="col-sm-1 control-label">Facebook :</div>
	            <div class="col-sm-3">
	                <input type="text" name="companyFacebook" id="companyFacebook" required class="form-control" minlength="2" placeholder="facebook" >
	            </div>
	            <div class="col-sm-1 control-label">Line :</div>
	            <div class="col-sm-3">
	                <input type="text" name="companyLine" id="companyLine" required class="form-control" minlength="2" placeholder="line" >
	            </div>
	        </div>
	        <div class="form-group row mb-3">
	            <div class="col-sm-1 control-label">ชื่อผู้ประสานงาน :</div>
	            <div class="col-sm-3">
	                <input type="text" name="coordinatorName" id="coordinatorName" required class="form-control" minlength="2" placeholder="ชื่อ" >
	            </div>
	            <div class="col-sm-1 control-label">เบอร์โทร :</div>
	            <div class="col-sm-3">
	                <input type="text" name="coordinatorPhoneNo" id="coordinatorPhoneNo" required class="form-control" minlength="2" placeholder="เบอรโทร" >
	            </div>
	        </div>
	        
            <div class="form-group row mb-3">
            <div class="form-group row mb-3 " >
	        	<div class="col-sm-2 control-label" >ข้อมูลนักศึกษา.</div>
	        	<div class="col-sm-2">
		    		<button type="button" onclick="addStudentField()" class="btn btn-primary">เพิ่มนักศึกษา + </button>
		    	</div>
	        </div>
	        <div class = "form-group row mb-3 student-field">
	       	<div class="form-group row mb-3">
        	<div class="col-sm-1 control-label">ชื่อนักศึกษา :<span id="studentCountDisplay">${studentCount}</span></div>
            <div class="col-sm-3">
                <input type="text" name="studentName[]" required class="form-control" minlength="2" placeholder="ชื่อ">
            </div>
            <div class="col-sm-1 control-label">นามสกุล :</div>
            <div class="col-sm-3">
                <input type="text" name="studentLastname[]" required class="form-control" minlength="2" placeholder="นามสกุล">
            </div>
        	</div>
        	<div class="form-group row mb-3">
        	<div class="col-sm-1 control-label">รหัสนักศึกษา:</div>
            <div class="col-sm-3">
            	<input type="text" name="studentId[]" required class="form-control" minlength="2" placeholder="รหัสนักศึกษา" onblur="checkStudentId()">
        		
        	</div>
        	<div class="col-sm-1 control-label">เบอร์โทร :</div>
        	<div class="col-sm-3">
            	<input type="text" name="studentPhoneNo[]" required class="form-control" minlength="2" placeholder="เบอร์โทรศัพท์">
        	</div>
        	</div>
        	<div class="form-group row mb-3"> 
        	<div class="col-sm-1 control-label">อีเมล์ :</div>
        	<div class="col-sm-3">
            	<input type="text" name="studentEmail[]" required class="form-control" minlength="2" placeholder="อีเมล์">
        	</div>
        	<div class="col-sm-2 control-label">อัปโหลด cv/transcript :</div>
        	<div class="col-sm-3">
        		<input type="file" id="docName[]" name="docName[]" accept=".pdf" required class="form-control" multiple>
    		</div>
        	</div>
	        </div>
        	</div>
        	<div class="form-group row mb-3" id="studentContainer"></div>
        	
        	
	    	<div class="form-group row mb-3">
            <div class="col-sm-4"></div>
            <div class="col-sm-3">
                <button type="submit" class="btn btn-primary" >บันทึก</button>
            </div>
        </div>
	    </div>
	</form>
	<%@include file="footer.jsp" %>
	
	<script>
	
    document.addEventListener('DOMContentLoaded', function() {
    	const companies = ${companies}; // สมมติว่ามีข้อมูล company เป็น array ใน JavaScript

        // ดึง element datalist
        const datalist = document.getElementById('companyList');

        // จำกัดจำนวนตัวเลือกให้แสดงได้ไม่เกิน 5 ตัวเลือก---------------------------------------------------
        const limit = 5;
        companies.slice(0, limit).forEach(company => {
            const option = document.createElement('option');
            option.value = company.companyName;
            option.setAttribute('data-id', company.companyId);
            option.setAttribute('data-address', company.companyAddress);
            option.setAttribute('data-phone', company.companyPhoneNo);
            option.setAttribute('data-email', company.companyEmail);
            option.setAttribute('data-line', company.companyLine);
            option.setAttribute('data-facebook', company.companyFacebook);
            option.setAttribute('data-cdtname', company.coordinatorName);
            option.setAttribute('data-cdtphone', company.coordinatorPhoneNo);
            datalist.appendChild(option);
        });
        ///-----------------------------------------------------------------------------------
        const companyNameInput = document.getElementById('companyName');
        companyNameInput.addEventListener('change', function() {
            const companyName = encodeURIComponent(this.value);
            if (companyName) {
                fetch(`/request-form/add-request-form-page?name=${companyName}`)
                    .then(response => response.json())
                    .then(company => {
                    	if (companyName) {
                            // เติมข้อมูลลงในฟิลด์ต่าง ๆ
                            document.getElementById('companyId').value = company.companyId || '';  // ดึง companyId
                            document.getElementById('companyAddress').value = company.companyAddress || '';
                            document.getElementById('companyPhoneNo').value = company.companyPhoneNo || '';
                            document.getElementById('companyEmail').value = company.companyEmail || '';
                            document.getElementById('companyFacebook').value = company.companyFacebook || '';
                            document.getElementById('companyLine').value = company.companyLine || '';
                            document.getElementById('coordinatorName').value = company.coordinatorName || '';
                            document.getElementById('coordinatorPhoneNo').value = company.coordinatorPhoneNo || '';
                        } else {
                            // เคลียร์ฟิลด์หากไม่พบบริษัท
                            document.getElementById('companyAddress').value = '';
                            document.getElementById('companyPhoneNo').value = '';
                            document.getElementById('companyEmail').value = '';
                            document.getElementById('companyFacebook').value = '';
                            document.getElementById('companyLine').value = '';
                            document.getElementById('coordinatorName').value = '';
                            document.getElementById('coordinatorPhoneNo').value = '';
                        }
                    })
                    
            }
        });
    });
	</script>

<script>
function updateCompanyId() {
    // รับค่า companyName ที่ผู้ใช้เลือก
    var companyNameInput = document.getElementById("companyName").value;
    
    // รับรายการ options ทั้งหมดจาก datalist
    var options = document.querySelectorAll("#companyList option");
    
    // เริ่มต้นให้ค่าเป็นค่าว่าง
    var companyId = "";
    var companyAddress = "";
    var companyPhoneNo = "";
    var companyEmail = "";
    var companyLine = "";
    var companyFacebook = "";
    var coordinatorName = "";
    var coordinatorPhoneNo = "";
    
    // วนลูปเพื่อค้นหา option ที่มีค่าเท่ากับ companyName ที่ผู้ใช้เลือก
    for (var i = 0; i < options.length; i++) {
        if (options[i].value === companyNameInput) {
            // ตั้งค่า companyId ที่ตรงกับ companyName
            companyId = options[i].dataset.id;
            companyAddress = options[i].dataset.address;
            companyPhoneNo = options[i].dataset.phone;
            companyEmail = options[i].dataset.email;
            companyLine = options[i].dataset.line;
            companyFacebook = options[i].dataset.facebook;
            coordinatorName = options[i].dataset.cdtname;
            coordinatorPhoneNo = options[i].dataset.cdtphone;
            break;
        }
    }
    
 	// อัปเดตฟิลด์ด้วยข้อมูลที่เลือก
    document.getElementById("companyId").value = companyId;
    document.getElementById("companyAddress").value = companyAddress;
    document.getElementById("companyPhoneNo").value = companyPhoneNo;
    document.getElementById("companyEmail").value = companyEmail;
    document.getElementById("companyLine").value = companyLine;
    document.getElementById("companyFacebook").value = companyFacebook;
    document.getElementById("coordinatorName").value = coordinatorName;
    document.getElementById("coordinatorPhoneNo").value = coordinatorPhoneNo;
}
</script>

	<script>
        document.addEventListener('DOMContentLoaded', function () {
            const selectElement = document.getElementById('coopEduYear');
            const currentYear = new Date().getFullYear() + 543; // ปีปัจจุบันในพุทธศักราช
            const numberOfYears = 5; // จำนวนปีที่ต้องการแสดง

            for (let i = 0; i < numberOfYears; i++) {
                const year = currentYear - i;
                const option = document.createElement('option');
                option.value = year;
                option.textContent = year;
                selectElement.appendChild(option);
            }
        });
        
    </script>
   	<script>
  		window.onload = function() {
  			let today = new Date().toISOString().substr(0, 10);
  		    let startDateElement = document.getElementById("startDate");
  		    let endDateElement = document.getElementById("endDate");

  		    startDateElement.value = today;
  		    startDateElement.min = today;

  		    // ตั้งค่าวันที่เริ่มต้นสำหรับ endDate ให้เป็น 2 เดือนหลังจากวันที่ปัจจุบัน
  		    let initialFutureDate = new Date();
  		    initialFutureDate.setMonth(initialFutureDate.getMonth() + 2);
  		    endDateElement.min = initialFutureDate.toISOString().substr(0, 10);
  		    endDateElement.value = initialFutureDate.toISOString().substr(0, 10);
    	   
    	 	// เพิ่ม event listener เมื่อมีการเปลี่ยนแปลงวันที่ในฟิลด์ startDate
    	    startDateElement.addEventListener('change', function() {
    	    let selectedDate = new Date(startDateElement.value);
    	      
    	  	// ตั้งค่าให้ endDate เป็น 2 เดือนหลังจากวันที่ที่เลือกใน startDate
    	     let futureDate = new Date(selectedDate);
    	     futureDate.setMonth(selectedDate.getMonth() + 2);
    	      
    	     endDateElement.min = futureDate.toISOString().substr(0, 10);
    	     endDateElement.value = futureDate.toISOString().substr(0, 10);
    	    });
  		};
	</script>
	
	
	
	
  <script>
  
  	let studentCount = 1;
 
    function addStudentField() {
    	
    	studentCount++;

    	document.getElementById('studentCountDisplay').innerText = studentCount;
    	
        const studentContainer = document.getElementById('studentContainer');
        const newStudentField = document.createElement('div');
        newStudentField.className = 'form-group row mb-3 student-field';
        newStudentField.innerHTML = `
           	<div class="student-form " >
        	<div class="form-group row mb-3">
        	<div class="col-sm-1 control-label">ชื่อนักศึกษา :</div>
            <div class="col-sm-3">
                <input type="text" name="studentName[]" id="studentName[]" required class="form-control" minlength="2" placeholder="ชื่อ">
            </div>
            <div class="col-sm-1 control-label">นามสกุล :</div>
            <div class="col-sm-3">
                <input type="text" name="studentLastname[]" id="studentLastname[]" required class="form-control" minlength="2" placeholder="นามสกุล">
            </div>
        	</div>
        	<div class="form-group row mb-3">
        	<div class="col-sm-1 control-label">รหัสนักศึกษา :</div>
            <div class="col-sm-3">
            	<input type="text" name="studentId[]" id="studentId[]" required class="form-control" minlength="2" placeholder="รหัสนักศึกษา" onblur="checkStudentId()">	
            </div>
        	<div class="col-sm-1 control-label">เบอร์โทร :</div>
        	<div class="col-sm-3">
            	<input type="text" name="studentPhoneNo[]" id="studentPhoneNo[]" required class="form-control" minlength="2" placeholder="เบอร์โทรศัพท์">
        	</div>
        	</div>
        	<div class="form-group row mb-3"> 
        	<div class="col-sm-1 control-label">อีเมล์ :</div>
        	<div class="col-sm-3">
            	<input type="text" name="studentEmail[]"  id="studentEmail[]" required class="form-control" minlength="2" placeholder="อีเมล์">
        	</div>
        	<div class="col-sm-2 control-label">อัปโหลด cv/transcript :</div>
        	<div class="col-sm-3">
        		<input type="file" id="docName[]" name="docName[]" accept=".pdf" required class="form-control" multiple>
        		<div id="fileNames" class="file-names mt-2"></div>
        	</div>
        	</div>
        	</div>
            <div class="col-sm-3">
                <button type="button" onclick="removeStudentField(this)" class="btn btn-danger">ลบออก</button>
            </div>
        `;
        studentContainer.appendChild(newStudentField);
        console.log("After increment:", newStudentField);
    }
    
    function removeStudentField(button) {
        const studentField = button.parentElement.parentElement;
        studentField.remove();
        studentCount--;
        document.getElementById('studentCountDisplay').innerText = studentCount;
        
     // อัปเดตหมายเลขของฟิลด์ที่เหลืออยู่หลังจากการลบ
        updateStudentFieldNumbers();
        
    }
    
    function updateStudentFieldNumbers() {
        const studentFields = document.querySelectorAll('.student-form');
        studentFields.forEach((field, index) => {
            const studentNumber = index + 1;
            field.querySelector('.control-label').innerText = `ชื่อนักศึกษา ${studentNumber}:`;
            field.querySelector('input[name^="studentName"]').name = `studentName${studentNumber}[]`;
            field.querySelector('input[name^="studentSurname"]').name = `studentSurname${studentNumber}[]`;
            field.querySelector('input[id^="studentName"]').id = `studentName${studentNumber}[]`;
            field.querySelector('input[id^="studentSurname"]').id = `studentSurname${studentNumber}[]`;
        });
    }
    
    function displaySelectedFiles(input, fileNamesContainerId) {
        const fileNamesContainer = document.getElementById(fileNamesContainerId);
        fileNamesContainer.innerHTML = ''; // Clear previous file names
        Array.from(input.files).forEach(file => {
            const fileNameElement = document.createElement('div');
            fileNameElement.textContent = file.docName;
            fileNamesContainer.appendChild(fileNameElement);
        });
    }
        
    
    
</script>
	
   	
</body>
</html>

