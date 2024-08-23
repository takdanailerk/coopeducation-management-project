package itsci.mju.coopeducation_management_project.model;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "coop_educations")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CoopEducation {

	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coopEduId;

    private String coopName;
    private Date startDate;
    private Date endDate;
    private String coopEduType;
    private String status;
    private String coopEduYear;
    private String coopEduSemester;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId")
    private Company company;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "majorId")
    private Major major;

    public CoopEducation() {}

	public CoopEducation(Long coopEduId, String coopName, Date startDate, Date endDate, String coopEduType,
			String status, String coopEduYear, String coopEduSemester, Company company, Major major) {
		super();
		this.coopEduId = coopEduId;
		this.coopName = coopName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.coopEduType = coopEduType;
		this.status = status;
		this.coopEduYear = coopEduYear;
		this.coopEduSemester = coopEduSemester;
		this.company = company;
		this.major = major;
	}

	public Long getCoopEduId() {
		return coopEduId;
	}

	public void setCoopEduId(Long coopEduId) {
		this.coopEduId = coopEduId;
	}

	public String getCoopName() {
		return coopName;
	}

	public void setCoopName(String coopName) {
		this.coopName = coopName;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCoopEduType() {
		return coopEduType;
	}

	public void setCoopEduType(String coopEduType) {
		this.coopEduType = coopEduType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCoopEduYear() {
		return coopEduYear;
	}

	public void setCoopEduYear(String coopEduYear) {
		this.coopEduYear = coopEduYear;
	}

	public String getCoopEduSemester() {
		return coopEduSemester;
	}

	public void setCoopEduSemester(String coopEduSemester) {
		this.coopEduSemester = coopEduSemester;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}


    
   
    
    
}
