package itsci.mju.coopeducation_management_project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import itsci.mju.coopeducation_management_project.model.Staff;
import itsci.mju.coopeducation_management_project.repository.StaffRepository;

@Service
public class StaffServiceImpl implements StaffService{

	@Autowired
	private StaffRepository staffRepository;
	
	
//	@Autowired
//    private BCryptPasswordEncoder passwordEncoder;

	
//	private final BCryptPasswordEncoder passwordEncoder;

	
//    public StaffServiceImpl(BCryptPasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
    
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
	
	
	@Override
	public Staff findByUsernameAndPassword(String username,String password) {   
		// TODO 
		return staffRepository.findByUsernameAndPassword(username,password);
	}
	
	
//	@Override
//	public Staff registerStaff(Staff staff) {
//			staff.setPassword(passwordEncoder.encode(staff.getPassword()));
//		return staffRepository.save(staff);
//    }

	
	
//	@Autowired
//	public Staff loadStaffByUsername(String username) throws UsernameNotFoundException{
//		 Staff user = staffRepository.findByUsername(username)
//	                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
//
//	        return new org.springframework.security.core.userdetails.User(
//	        		user.getUsername(),
//	        		user.getPassword(),
//	                new ArrayList<>()
//	        );
//	    }
//	}
	
	@Override
	public List<Staff> getAllStaffs() {
		// TODO Auto-generated method stub
		return staffRepository.findAll();
	}

	@Override
	public Staff getStaffById(Long staffId) {
		// TODO Auto-generated method stub
		return staffRepository.getReferenceById(staffId);
	}
	
//	@Override
//	public Staff addStaff(Map<String, String> requestBody) {
//		// TODO Auto-generated method stub
//		Long staffId = ((staffRepository.getMaxStaffId() == null)? 0 : staffRepository.getMaxStaffId()) + 1;
//		String staffName = requestBody.get("staffName");
//		String staffSurname = requestBody.get("staffSurname");
//		
//		Long majorId = Long.parseLong(requestBody.get("majorId"));
//		Staff staff = new Staff(staffId, staffName, staffSurname,null);
//		return staffRepository.save(staff);
//	}

//	@Override
//	public Long addStaff(Staff staff) {
//        return staffService.addStaff(staff);
//	}

	
	@Override
	public Staff addStaff(Staff staff) {
        return staffRepository.save(staff);
	}
	
	
	@Override
	public Staff updateStaff(Staff updateStaff) {
		// TODO Auto-generated method stub
		if (updateStaff != null && updateStaff.getStaffId() != null) {
            Staff existingStaff = staffRepository.findById(updateStaff.getStaffId()).orElse(null);
            if (existingStaff != null) {
                existingStaff.setStaffName(updateStaff.getStaffName());
                existingStaff.setStaffSurname(updateStaff.getStaffSurname());
                // อัปเดตข้อมูลอื่นๆ ตามที่จำเป็น
                staffRepository.save(existingStaff); // save() สำหรับอัปเดต
            }
        }
		return staffRepository.save(updateStaff);
	}

	
	@Override
	public void deleteStaff(Long staffId) {
		// TODO Auto-generated method stub
		Staff staff = staffRepository.getReferenceById(staffId);
		staffRepository.delete(staff);
	}




//	@Override
//	public Long addstaff(Long staffId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//    @Override
//    public Staff loadStaffByUsername(String username) throws UsernameNotFoundException {
////        Staff staff = staffRepository.findByUsername(username)
////                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
////        
////        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + staff.getRole().toUpperCase());
////        
////        return new org.springframework.security.core.userdetails.User(staff.getUsername(), staff.getPassword(), Collections.singletonList(authority));
//    return null;
//    }

	
}
