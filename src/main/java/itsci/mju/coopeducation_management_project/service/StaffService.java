package itsci.mju.coopeducation_management_project.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//import org.springframework.security.core.userdetails.UsernameNotFoundException;

//import org.springframework.security.core.userdetails.UsernameNotFoundException;

//import org.springframework.security.core.userdetails.UsernameNotFoundException;

import itsci.mju.coopeducation_management_project.model.Staff;


public interface StaffService {

	List<Staff> getAllStaffs();
	Staff getStaffById(Long staffId);
	Staff addStaff(Staff staff);
//	Staff addStaff(Map<String, String> requestBody);
	Staff updateStaff(Staff updateStaff);
	void deleteStaff(Long StaffId);
	
	Staff findByUsername(String username);
	
//	Staff registerStaff(Staff staff);
	
//	Staff loadStaffByUsername(String username) throws UsernameNotFoundException;


//	Optional<Staff> findByUsername(String username);

}
