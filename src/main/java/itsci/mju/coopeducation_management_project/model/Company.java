package itsci.mju.coopeducation_management_project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "companies")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Company {

	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY).
    private Long companyId;

	private String companyName;
    private String companyAddress;
    private String companyPhoneNo;
    private String companyEmail;
    private String companyLine;
    private String companyFacebook;
    private String coordinatorName;
    private String coordinatorPhoneNo;
    
    public Company() {}
    
  
	public Company(Long companyId, String companyName, String companyAddress, String companyPhoneNo,
			String companyEmail, String companyLine, String companyFacebook, String coordinatorName,
			String coordinatorPhoneNo) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyPhoneNo = companyPhoneNo;
		this.companyEmail = companyEmail;
		this.companyLine = companyLine;
		this.companyFacebook = companyFacebook;
		this.coordinatorName = coordinatorName;
		this.coordinatorPhoneNo = coordinatorPhoneNo;
	}
	
	public Long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyPhoneNo() {
		return companyPhoneNo;
	}
	public void setCompanyPhoneNo(String companyPhoneNo) {
		this.companyPhoneNo = companyPhoneNo;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getCompanyLine() {
		return companyLine;
	}
	public void setCompanyLine(String companyLine) {
		this.companyLine = companyLine;
	}
	public String getCompanyFacebook() {
		return companyFacebook;
	}
	public void setCompanyFacebook(String companyFacebook) {
		this.companyFacebook = companyFacebook;
	}
	public String getCoordinatorName() {
		return coordinatorName;
	}
	public void setCoordinatorName(String coordinatorName) {
		this.coordinatorName = coordinatorName;
	}
	public String getCoordinatorPhoneNo() {
		return coordinatorPhoneNo;
	}
	public void setCoordinatorPhoneNo(String coordinatorPhoneNo) {
		this.coordinatorPhoneNo = coordinatorPhoneNo;
	}
}
