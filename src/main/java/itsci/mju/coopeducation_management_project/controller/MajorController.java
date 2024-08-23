package itsci.mju.coopeducation_management_project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import itsci.mju.coopeducation_management_project.model.Major;
import itsci.mju.coopeducation_management_project.model.Staff;
import itsci.mju.coopeducation_management_project.repository.MajorRepository;
import itsci.mju.coopeducation_management_project.service.MajorService;
import itsci.mju.coopeducation_management_project.service.StaffService;
import jakarta.persistence.NoResultException;

@Controller
@RequestMapping("/majors")
public class MajorController {

	@Autowired
	private MajorService majorService;
	
	@Autowired
	private MajorRepository majorRepository;
	
	
	@Autowired
	private StaffService staffService;
	
	
	@GetMapping("/list-major-page")
	public String goToListMajorsPage (Model model) {
		model.addAttribute("staffs", staffService.getAllStaffs());
		model.addAttribute("majors", majorService.getAllMajors());
		return "list-major";
	}
	
	@GetMapping("/add-major-page")
	public String goToAddMajorPage (Model model) {
		model.addAttribute("staffs", staffService.getAllStaffs());
		model.addAttribute("majors", majorService.getAllMajors());
		return "add-major";
	}
	
//	@GetMapping("/update-major-page/{majorId}")
//	public String goToUpdateMajorPage (Model model, @PathVariable String majorId) {
//		model.addAttribute("major", majorService.getMajorById(Long.valueOf(majorId)));
//		return "update-major";
//	}
	
//	@GetMapping("/update-major-page/{majorId}/{staffId}")
//	public String goToUpdateMajorPage (@RequestParam("majorId") String majorId,@RequestParam("staffId") String staffId, Model model) {
////		model.addAttribute("major", majorService.getMajorById(Long.valueOf(majorId)));
//		
//		// Fetch Major and Staff details based on the provided IDs
//        Major major = majorService.getMajorById(Long.valueOf(majorId));
//        Staff staff = staffService.getStaffById(Long.valueOf(staffId));
//
//        // Add the retrieved entities to the model
//        model.addAttribute("major", major);
//        model.addAttribute("staff", staff);
//		return "update-major";
//	}
	
	
	@GetMapping("/update-major-page/{staffId}")
	public String goToUpdateMajorPage (Model model, @PathVariable String staffId) {
		Staff staff = staffService.getStaffById(Long.valueOf(staffId));
		Major major = majorService.getMajorById(Long.valueOf(staffId));

//		Major major = staff.getMajor();
		model.addAttribute("major", major);
	    model.addAttribute("staff", staff);
	    
//	    List<Staff> staffs = staffService.getAllStaffs();
//        model.addAttribute("staffs",staffs);
//	    List<Major> majors = majorService.getAllMajors();
//        model.addAttribute("majors",majors);
		return "update-major";
	}
	
	
	@PostMapping("/add")
	public String addMajor (@RequestParam Map<String, String> requestBody) {
		majorService.addMajor(requestBody);
		return "redirect:/majors/add-major-page";
	}
	
	
//	//การอัพเดทข้อมูล
//	@PostMapping("/update/{staffId}")
//	public String updateMajor (@RequestParam Map<String, String> requestParams){
////		
//		String staffId = requestParams.get("staffId");
//        String staffName = requestParams.get("staffName");
//        String staffSurname = requestParams.get("staffSurname");
//        String majorId = requestParams.get("majorId");
//        String majorName = requestParams.get("majorName");
//        
//        staffService.updateStaffAndMajor(staffId, staffName, staffSurname, majorId, majorName);
//
//        
//		return "redirect:/majors/list-majors-page";
//	}
	 
//	//การอัพเดทข้อมูล
//	@PostMapping("/update/{majorId}")
//	public String updateMajor (@PathVariable String majorId,
//			@ModelAttribute("staffs") Staff staff,
//			@ModelAttribute("majors") Major major){
//		
//        	staff.setStaffId(Long.valueOf(majorId)); // ตั้งค่า id ของ staff
//        	staffService.updateStaff(staff);

//        	major.setMajorId(Long.valueOf(majorId)); // ตั้งค่า id ของ major
//        	majorService.updateMajor(major); // อัปเดต major ด้วย majorService

		
//		updateStaff.setStaffId(Long.valueOf(majorId));
//		majorService.updateMajor(majorId);
//		
//		updateMajor.setMajorId(Long.valueOf(majorId));
//		staffService.updateStaff(updatedStaff);
//		return "redirect:/majors/list-majors-page";
//	}
	
	@GetMapping("/delete/{staffId}")
	public String deleteMajor(@PathVariable String staffId) {
	try {
        staffService.deleteStaff(Long.valueOf(staffId));
    } catch (NoResultException e) {
        // จัดการกรณีไม่พบ staffId ที่ระบุ
        // ตัวอย่างเช่น สามารถ redirect ไปยังหน้า error หรือแสดงข้อความผิดพลาดได้
        return "error-page";
    }
	return "redirect:/majors/list-majors-page";
	}
	
////		majorService.deleteMajor(Long.valueOf(majorId));
////		return "redirect:/majors/list-majors-page";
//	}
	
	@PostMapping("/update/{staffId}")
	public String updateStaff (@PathVariable String staffId,@PathVariable String majorId, @ModelAttribute("staff") Staff updateStaff,
            @ModelAttribute("major") Major updateMajor) {
		
//		 ดึงข้อมูล Staff เดิมจากฐานข้อมูลตาม staffId
	    Staff existingStaff = staffService.getStaffById(Long.valueOf(staffId));
	    
	    if (existingStaff != null) {
	        // ดึง MajorId เดิมจาก Staff
	        Long existingMajorId = existingStaff.getMajor().getMajorId();
//	        Major existingMajor = majorRepository.findById(updateMajor.getMajorId()).orElse(null);
	        // ตั้งค่า MajorId เดิมให้กับ Major ที่กำลังจะอัปเดต
	        updateMajor.setMajorId(existingMajorId);
	        
	        // อัปเดตข้อมูล Major
	        majorService.updateMajor(updateMajor);
//	         ตั้งค่า StaffId เดิมให้กับ Staff ที่กำลังจะอัปเดต
	        updateStaff.setStaffId(Long.valueOf(staffId));
	        
	        // อัปเดตข้อมูล Staff
	        staffService.updateStaff(updateStaff);
	    } else {
	        // Handle the case where the staff does not exist
	        return "redirect:/majors/error"; // ตัวอย่างการ redirect ไปยังหน้า error
	    }
		
//		updateMajor.setMajorId(Long.valueOf(staffId));
//		majorService.updateMajor(updateMajor);
		
//		updateStaff.setStaffId(Long.valueOf(staffId));
//		staffService.updateStaff(updateStaff);
		
	
	
//		 Staff existingStaff = staffService.getStaffById(Long.valueOf(staffId));
//
//	        // อัปเดตข้อมูลของ major และ staff
//	        existingStaff.setStaffName(existingStaff.getStaffName());
//	        existingStaff.setStaffSurname(existingStaff.getStaffSurname());
//	        
//	        Major existingMajor = existingStaff.getMajor();
//	        if (existingMajor == null) {
//	            existingMajor = new Major();
//	            existingStaff.setMajor(existingMajor);
//	        }
//	        existingMajor.setMajorName(existingMajor.getMajorName());
//	        existingMajor.setMajorPhoneNo(existingMajor.getMajorPhoneNo());
//	        existingMajor.setMajorFax(existingMajor.getMajorFax());
//	        existingMajor.setMajorEmail(existingMajor.getMajorEmail());
//	        majorService.updateMajor(existingMajor);
//	        
////	        Major existingMajor = existingStaff.getMajor();
////	        existingMajor.setMajorName(existingMajor.getMajorName());
////	        existingMajor.setMajorPhoneNo(existingMajor.getMajorPhoneNo());
////	        existingMajor.setMajorFax(existingMajor.getMajorFax());
////	        existingMajor.setMajorEmail(existingMajor.getMajorEmail());
//
//	        // บันทึกข้อมูลที่อัปเดต
////	        majorService.updateMajor(existingMajor);
//	        staffService.updateStaff(existingStaff);
		
		// ดึงข้อมูล staff จากฐานข้อมูล
//	    Staff existingStaff = staffService.getStaffById(Long.valueOf(staffId));
//
//	    // ดึง Major ที่เกี่ยวข้องจาก Staff
//	    Major existingMajor = existingStaff.getMajor();
//
//	    if (existingMajor != null) {
//	        // อัปเดตข้อมูล Major ที่มีอยู่
//	        existingMajor.setMajorName(existingMajor.getMajorName());
//	        existingMajor.setMajorPhoneNo(existingMajor.getMajorPhoneNo());
//	        existingMajor.setMajorFax(existingMajor.getMajorFax());
//	        existingMajor.setMajorEmail(existingMajor.getMajorEmail());
//
//	        // บันทึก Major ที่อัปเดตแล้วกลับไปยังฐานข้อมูล
//	        majorService.updateMajor(existingMajor);
//	    } else {
//	        // Handle case when the Major is null (optional)
//	        // e.g., throw an exception or create a new Major
//	    }
//
//	    // อัปเดตข้อมูล staff
//	    existingStaff.setStaffName(existingStaff.getStaffName());
//	    existingStaff.setStaffSurname(existingStaff.getStaffSurname());
//	    staffService.updateStaff(existingStaff);
	
	
	
		return "redirect:/majors/list-majors-page";
	}
	
//	@PostMapping("/update/{majorId}")
//	public String updateMajor (@PathVariable String majorId, @ModelAttribute("major") Major updateMajor) {
//		
//		updateMajor.setMajorId(Long.valueOf(majorId));
//		majorService.updateMajor(updateMajor);
//		
//		return "redirect:/majors/list-majors-page";
//	}
	
		
	
}
