package itsci.mju.coopeducation_management_project.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itsci.mju.coopeducation_management_project.model.AcceptanceStatus;
import itsci.mju.coopeducation_management_project.model.Document;
import itsci.mju.coopeducation_management_project.model.Student;
import itsci.mju.coopeducation_management_project.repository.AcceptanceRepository;
import itsci.mju.coopeducation_management_project.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	public DocumentRepository documentRepository;
	
	@Autowired
    private AcceptanceRepository acceptanceRepository;
	
	@Override
	public List<Document> getAllDocuments() {
		// TODO Auto-generated method stub
		return documentRepository.findAll();
	}

	@Override
	public Document getDocumentById(Long docId) {
		// TODO Auto-generated method stub
		return documentRepository.getReferenceById(docId);
				
	}

	@Override
	public Document addDocument(Document document) {
		// TODO Auto-generated method stub
		return documentRepository.save(document);
	}

	@Override
	public Document updateDocument(Document updateDocument) {
		// TODO Auto-generated method stub
		return documentRepository.save(updateDocument);
	}

	@Override
	public void deletlDocument(Long docId) {
		// TODO Auto-generated method stub
		Document document = documentRepository.getReferenceById(docId);
		documentRepository.delete(document);
	}

	@Override
	public Document findById(Long docId) {
		// TODO Auto-generated method stub
		return documentRepository.findById(docId).orElse(null);
	}
	
//	@Override
//	public List<Document> findByStudentId(String studentId) {
//		// TODO Auto-generated method stub
//		return documentRepository.findByStudentStudentId(studentId);
//	}
//
//	@Override
//	public List<Document> getDocumentsByStudentId(String studentId) {
//        return documentRepository.findByStudentStudentId(studentId);
//    }

//	@Override
//	public List<Document> findByCoopEduId(Long coopEduId) {
//		// TODO Auto-generated method stub
//		return documentRepository.findByCoopEducationId(coopEduId);
//	}

	
//	public List<Document> findDocumentsByCoopEduId(Long coopEduId) {
//	    // ดึง AcceptanceStatus ที่เกี่ยวข้องกับ coopEduId
//	    List<AcceptanceStatus> acceptanceStatuses = acceptanceRepository.findByCoopEducation_CoopEduId(coopEduId);
//
//	    // ดึง studentId ของนักศึกษาที่อยู่ใน AcceptanceStatus เหล่านั้น
//	    List<String> studentIds = acceptanceStatuses.stream()
//	                                              .map(AcceptanceStatus::getStudent)
//	                                              .map(Student::getStudentId)
//	                                              .collect(Collectors.toList());
//
//	    // ดึงข้อมูลไฟล์ที่ตรงกับ studentIds ที่ได้มา
//	    return documentRepository.findByStudent_StudentIdIn(studentIds);
//	}

}
