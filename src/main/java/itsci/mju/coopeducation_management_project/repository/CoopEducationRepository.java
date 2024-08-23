package itsci.mju.coopeducation_management_project.repository;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import itsci.mju.coopeducation_management_project.model.CoopEducation;

public interface CoopEducationRepository extends JpaRepository<CoopEducation,Long>{

	@Query(value = "SELECT c.coopEduId FROM coop_educations c ORDER BY c.coopEduId DESC LIMIT 1", nativeQuery = true)
    Long getMaxCoopEduId(); 
	
//	@Query("SELECT ce FROM CoopEducation ce LEFT JOIN FETCH ce.students WHERE ce.coopEduId IN (SELECT DISTINCT ce2.coopEduId FROM CoopEducation ce2)")
//	List<CoopEducation> findAllWithStudents();
	
//	InputStream generatePdfFromJson(Map<String, Object> jsonData);
}
