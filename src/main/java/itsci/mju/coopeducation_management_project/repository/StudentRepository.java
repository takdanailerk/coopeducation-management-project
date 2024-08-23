package itsci.mju.coopeducation_management_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import itsci.mju.coopeducation_management_project.model.Student;

public interface StudentRepository extends JpaRepository<Student,String>{

//	List<Student> findByCoopEduId(Long coopEduId);
	
	
	
}
