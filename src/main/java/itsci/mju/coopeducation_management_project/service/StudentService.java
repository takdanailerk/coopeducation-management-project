package itsci.mju.coopeducation_management_project.service;

import java.util.List;

import itsci.mju.coopeducation_management_project.model.AcceptanceStatus;
import itsci.mju.coopeducation_management_project.model.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	Student getStudentById(String studentId);
	Student addStudent(Student student);
	Student updateStudent(Student updateStudent);
	void deleteStudent(String studentId);
//	List<Student> findByCoopEduId(Long valueOf);
	
//	List<Student> findByCoopEduId(Long coopEduId);

}
