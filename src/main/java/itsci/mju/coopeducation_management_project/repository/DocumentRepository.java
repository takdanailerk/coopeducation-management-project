package itsci.mju.coopeducation_management_project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import itsci.mju.coopeducation_management_project.model.Document;

public interface DocumentRepository extends JpaRepository<Document,Long>{
	
	@Query(value = "SELECT d.docId FROM documents d ORDER BY d.docId DESC LIMIT 1", nativeQuery = true)
    Long getMaxDocId();

	

//	List<Document> findByStudentStudentId(String studentId);
	

//	List<Document> findByStudent_StudentIdIn(List<String> studentIds);
	

//	 List<Document> findByStudent_StudentId(String studentId);
	 
//    int MAX_FILE_SIZE = 100 * 1024 * 1024; // 100 MB

//	Optional<Document> findById(Long docId);
	
//	 List<Document> findByStudent_StudentIdIn(List<String> studentIds);


}
