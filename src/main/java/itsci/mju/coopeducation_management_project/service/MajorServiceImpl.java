package itsci.mju.coopeducation_management_project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import itsci.mju.coopeducation_management_project.model.Major;
import itsci.mju.coopeducation_management_project.model.Staff;
import itsci.mju.coopeducation_management_project.repository.MajorRepository;
import itsci.mju.coopeducation_management_project.repository.StaffRepository;

@Service
public class MajorServiceImpl implements MajorService {

	@Autowired
	private MajorRepository majorRepository;
	
	
	@Autowired
	private StaffRepository staffRepository;
	
	@Autowired
    private StaffService staffService;

	
	@Override
	public List<Major> getAllMajors() {
		return majorRepository.findAll();
	}
	
	@Override
	public Major getMajorById(Long majorId) {
		return majorRepository.getReferenceById(majorId);
	}
	
	
	@Override
	public void addMajor(Map<String, String> requestBody) {
		
		Long majorId = ((majorRepository.getMaxMajorId() == null)? 0 : majorRepository.getMaxMajorId()) + 1;
//		Long majorId = requestBody.get("null");
		String majorName = requestBody.get("majorName");
		String majorPhoneNo = requestBody.get("majorPhoneNo");
		String majorFax = requestBody.get("majorFax");
		String majorEmail = requestBody.get("majorEmail");
		
		Major major = new Major();
		major.setMajorId(majorId);
		major.setMajorName(majorName);
		major.setMajorPhoneNo(majorPhoneNo);
		major.setMajorFax(majorFax);
		major.setMajorEmail(majorEmail);
//		major.setStaff(staff);	
		majorRepository.save(major);
		
		
//		Long staffId = ((staffRepository.getMaxStaffId() == null)? 0 : staffRepository.getMaxStaffId()) + 1;
//		String staffName = requestBody.get("staffName");
//	    String staffSurname = requestBody.get("staffSurname");
//	    String role = requestBody.get("role");
//	    String username = requestBody.get("username");
//	    String password = requestBody.get("password");
//	    
//	    Staff staff = new Staff(staffId, staffName, staffSurname, role, username, password, major);
//	    staff.setStaffName(staffName);
//	    staff.setStaffSurname(staffSurname);
//	    staff.setMajor(major);
//	    staffRepository.save(staff);

		
	}

//	@Override
//    public Staff getStaffById(Long staffId) {
//        return staffRepository.findById(staffId).orElseThrow(() -> new NoSuchElementException("ไม่พบข้อมูลอาจารย์"));
//    }
//	
//	@Override
//	public void updateMajor(Major updatedMajor,String majorId) {
//		// TODO Auto-generated method stub
//		 Staff staff = staffRepository.findById(staffId).orElseThrow(() -> new NoSuchElementException("ไม่พบข้อมูลอาจารย์"));
//
//	        Major major = staff.getMajor();
//	        major.setMajorName(updatedStaff.getMajor().getMajorName());
//	        major.setMajorPhoneNo(updatedStaff.getMajor().getMajorPhoneNo());
//	        major.setMajorFax(updatedStaff.getMajor().getMajorFax());
//	        major.setMajorEmail(updatedStaff.getMajor().getMajorEmail());
//
//	        staff.setStaffName(updatedStaff.getStaffName());
//	        staff.setStaffSurname(updatedStaff.getStaffSurname());
//
//	        majorRepository.save(major);
//	        staffRepository.save(staff);
//	}
	
	@Override
	public void deleteMajor(Long majorId) {
		Major major = majorRepository.getReferenceById(majorId);
		majorRepository.delete(major);
	}

	public Major updateMajor(Major updateMajor) {
		
////		 ดึงข้อมูล Staff เดิมจากฐานข้อมูลตาม staffId
//		    Staff existingStaff = staffService.getStaffById(Long.valueOf(staffId));
		    
//		    if (existingStaff != null) {
//		        // ดึง MajorId เดิมจาก Staff
//		        Long existingMajorId = existingStaff.getMajor().getMajorId();
		        Major existingMajor = majorRepository.findById(updateMajor.getMajorId()).orElse(null);
//		         ตั้งค่า MajorId เดิมให้กับ Major ที่กำลังจะอัปเดต
//		        updateMajor.setMajorId(existingMajorId);
	    if (updateMajor != null && updateMajor.getMajorId() != null) {
//	        Major existingMajor = majorRepository.findById(updateMajor.getMajorId()).orElse(null);
	        
	        if (existingMajor != null) {
	            existingMajor.setMajorId(updateMajor.getMajorId());
	            existingMajor.setMajorName(updateMajor.getMajorName());
	            existingMajor.setMajorPhoneNo(updateMajor.getMajorPhoneNo());
	            existingMajor.setMajorFax(updateMajor.getMajorFax());
	            existingMajor.setMajorEmail(updateMajor.getMajorEmail());
	            majorRepository.save(existingMajor); // save() สำหรับอัปเดต
	            return existingMajor; // คืนค่าที่อัปเดตแล้ว
	        }
	    }
	    return null; // หรือให้ส่งค่าที่ต้องการกลับ ถ้าหา Major ไม่เจอหรือ updateMajor เป็น null
	}
	
//	@Override
//	public void updateMajorAndStaff(Map<String, String> requestParams) {
//		Long staffId;
//		// TODO Auto-generated method stub
//		Staff staff = staffRepository.findById(staffId).orElseThrow(() -> new IllegalArgumentException("Invalid staff ID: " + staffId));
//
//        Long majorId;
//		// ค้นหา Major ตาม majorId
//        Major major = majorRepository.findById(majorId).orElseThrow(() -> new IllegalArgumentException("Invalid major ID: " + majorId));
//
//        // แก้ไขข้อมูล Staff
//        staff.setStaffName(staffName);
//        staff.setStaffSurname(staffSurname);
//        staff.setMajor(major);  // กำหนด Major ใหม่ให้กับ Staff หากมีการเปลี่ยนแปลง
//
//        // แก้ไขข้อมูล Major หากจำเป็น
//        major.setMajorName(majorName);
//        // ... set other fields of Major
//
//        // บันทึกข้อมูลที่แก้ไข
//        staffRepository.save(staff);
//        majorRepository.save(major);
//	}


}
