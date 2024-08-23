package itsci.mju.coopeducation_management_project.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.element.Paragraph;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "documents")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Document {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docId;

    private String docName;
    private Date uploadDate;
    private String docType;
    
    @Lob
    @Column(name = "fileData",columnDefinition = "LONGBLOB")
    private byte[] fileData;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    private Student student;

    
    public Document(Long docId, String docName, Date uploadDate, String docType, byte[] fileData, Student student) {
		super();
		this.docId = docId;
		this.docName = docName;
		this.uploadDate = uploadDate;
		this.docType = docType;
		this.fileData = fileData;
		this.student = student;
	}

	

	public Document(PdfDocument pdf) {
		// TODO Auto-generated constructor stub
	}



	public Document() {
		// TODO Auto-generated constructor stub
	}



	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
//	public void close() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void add(Paragraph setFont) {
//		// TODO Auto-generated method stub
//		
//	}
//    
	
    
    
}
