package itsci.mju.coopeducation_management_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import itsci.mju.coopeducation_management_project.model.Major;

public interface MajorRepository extends JpaRepository<Major, Long> {

	@Query(value = "SELECT m.majorId FROM majors m ORDER BY m.majorId DESC LIMIT 1", nativeQuery = true)
    Long getMaxMajorId();
	
}
