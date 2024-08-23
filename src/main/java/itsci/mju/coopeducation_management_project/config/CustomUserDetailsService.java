package itsci.mju.coopeducation_management_project.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import itsci.mju.coopeducation_management_project.model.Staff;
import itsci.mju.coopeducation_management_project.repository.StaffRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private StaffRepository staffRepository;  // ใช้ StaffRepository สำหรับดึงข้อมูลผู้ใช้
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Staff staff = staffRepository.findByUsername(username);
				if (staff == null) {
		            throw new UsernameNotFoundException("User not found with username: " + username);
		        }
		// คืนค่า UserDetails โดยใช้ข้อมูลจาก Staff
        return new org.springframework.security.core.userdetails.User(
                staff.getUsername(),
                staff.getPassword(),
                new ArrayList<>()
        );
	}

}
