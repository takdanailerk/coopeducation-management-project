package itsci.mju.coopeducation_management_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import itsci.mju.coopeducation_management_project.model.AcceptanceStatus;
import itsci.mju.coopeducation_management_project.model.Document;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

public interface AcceptanceRepository extends JpaRepository<AcceptanceStatus,Long>{

	@Query(value = "SELECT a.acceptStatId FROM acceptance_status a ORDER BY a.acceptStatId DESC LIMIT 1", nativeQuery = true)
    Long getMaxAcceptenceId();
	
//	@Query("SELECT a FROM Acceptance a JOIN FETCH a.coopEducation JOIN FETCH a.student")
//    List<AcceptanceStatus> findAllWithDetails();
	
	List<AcceptanceStatus> findByCoopEducation_CoopEduId(Long coopEduId);

	
	
	//void deleteByCoopEduId(Long coopEduId);
	

//	List<Document> findDocuments_ByCoopEduId(Long coopEduId);
	
}
