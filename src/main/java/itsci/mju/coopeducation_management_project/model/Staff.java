package itsci.mju.coopeducation_management_project.model;

import java.util.Collection;
import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import itsci.mju.coopeducation_management_project.enumerator.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "staffs")
public class Staff implements UserDetails {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffId;

    private String staffName;
    private String staffSurname;
    private String staffPhoneNo;
    private String staffEmail;
    
    @Enumerated(EnumType.STRING)
    private Role role;
    
    private String username;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "majorId")
    private Major major;
    
    // Default constructor
    public Staff() {
    }

	public Staff(Long staffId, String staffName, String staffSurname, String staffPhoneNo, String staffEmail, Role role,
			String username, String password, Major major) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffSurname = staffSurname;
		this.staffPhoneNo = staffPhoneNo;
		this.staffEmail = staffEmail;
		this.role = role;
		this.username = username;
		this.password = password;
		this.major = major;
	}

	public Long getStaffId() {
		return staffId;
	}
	
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	
	public String getStaffName() {
		return staffName;
	}
	
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	
	public String getStaffSurname() {
		return staffSurname;
	}
	
	public void setStaffSurname(String staffSurname) {
		this.staffSurname = staffSurname;
	}
	
	public String getStaffPhoneNo() {
		return staffPhoneNo;
	}
	
	public void setStaffPhoneNo(String staffPhoneNo) {
		this.staffPhoneNo = staffPhoneNo;
	}
	
	public String getStaffEmail() {
		return staffEmail;
	}
	
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	
	public Role getRole() {
		return role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Major getMajor() {
		return major;
	}
	
	public void setMajor(Major major) {
		this.major = major;
	}
	
	public User withUsername(String username) {
	    this.username = username;
	     // คืนค่า User เพื่อให้สามารถใช้แบบ chaining ได้
		return this.withUsername(username);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

}
