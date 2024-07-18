package itsci.mju.coopeducation_management_project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "majors")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Major {

	@Id
	private Long majorId;
	
	private String majorName;
	private String majorPhoneNo;
	private String majorFax;
	private String majorEmail;
	
	public Major () {}
	
	public Major(Long majorId, String majorName, String majorPhoneNo, String majorFax, String majorEmail) {
		super();
		this.majorId = majorId;
		this.majorName = majorName;
		this.majorPhoneNo = majorPhoneNo;
		this.majorFax = majorFax;
		this.majorEmail = majorEmail;
	}

	public Long getMajorId() {
		return majorId;
	}
	
	public void setMajorId(Long majorId) {
		this.majorId = majorId;
	}
	
	public String getMajorName() {
		return majorName;
	}
	
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	
	public String getMajorPhoneNo() {
		return majorPhoneNo;
	}
	
	public void setMajorPhoneNo(String majorPhoneNo) {
		this.majorPhoneNo = majorPhoneNo;
	}
	
	public String getMajorFax() {
		return majorFax;
	}
	
	public void setMajorFax(String majorFax) {
		this.majorFax = majorFax;
	}
	
	public String getMajorEmail() {
		return majorEmail;
	}
	
	public void setMajorEmail(String majorEmail) {
		this.majorEmail = majorEmail;
	}
	
}
