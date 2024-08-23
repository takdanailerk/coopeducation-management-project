package itsci.mju.coopeducation_management_project.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import itsci.mju.coopeducation_management_project.model.Document;

public interface DocumentService {
	
	List<Document> getAllDocuments();
	Document getDocumentById(Long docId);
	Document addDocument(Document document);
	Document updateDocument(Document updateDocument);
	void deletlDocument (Long docId);
	Document findById(Long docId);
//	Document findDocumentByStudentId(Long studentId);
//	List<Document> findDocumentsByStudentId(String studentId);
//	List<Document> findByCoopEduId(Long coopEduId);
//	List<Document> findByCoopEduId(Long valueOf);
	
//	List<Document> findByStudentId(String studentId);
//	List<Document> getDocumentsByStudentId(String studentId);
	
//	Document findDocumentByStudentId(Long studentId);
	
//	ByteArrayInputStream generatePdf(String title, String content);
}

