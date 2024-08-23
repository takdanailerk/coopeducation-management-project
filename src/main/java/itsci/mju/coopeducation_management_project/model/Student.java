package itsci.mju.coopeducation_management_project.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "students" , uniqueConstraints = @UniqueConstraint (columnNames = "studentId"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student {

	@Id
	@Column(name = "studentId", unique = true, nullable = false)
    private String studentId;
    private String studentName;
    private String studentLastname;
    private String studentPhoneNo;
    private String studentEmail;
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Document> documents;
    
    public Student() {
    }
    
    
    
	public List<Document> getDocuments() {
		return documents;
	}



	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}



	public Student(String studentId, String studentName, String studentLastname, String studentPhoneNo,
			String studentEmail) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentLastname = studentLastname;
		this.studentPhoneNo = studentPhoneNo;
		this.studentEmail = studentEmail;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentLastname() {
		return studentLastname;
	}
	public void setStudentLastname(String studentLastname) {
		this.studentLastname = studentLastname;
	}
	public String getStudentPhoneNo() {
		return studentPhoneNo;
	}
	public void setStudentPhoneNo(String studentPhoneNo) {
		this.studentPhoneNo = studentPhoneNo;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
    
    
}
