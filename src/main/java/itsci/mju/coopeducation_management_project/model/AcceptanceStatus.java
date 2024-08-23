package itsci.mju.coopeducation_management_project.model;

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
@Table(name = "acceptance_status")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AcceptanceStatus {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long acceptStatId;
		private String acceptStatus;

	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "coopEduId")
	    private CoopEducation coopEducation;

	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "studentId")
	    private Student student;
	    
	    public AcceptanceStatus () {
	    	
	    }
	    
	    public Long getAcceptStatId() {
			return acceptStatId;
		}

		public void setAcceptStatId(Long acceptStatId) {
			this.acceptStatId = acceptStatId;
		}

		public String getAcceptStatus() {
			return acceptStatus;
		}

		public void setAcceptStatus(String acceptStatus) {
			this.acceptStatus = acceptStatus;
		}

		public CoopEducation getCoopEducation() {
			return coopEducation;
		}

		public void setCoopEducation(CoopEducation coopEducation) {
			this.coopEducation = coopEducation;
		}

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

}
