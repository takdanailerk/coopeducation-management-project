package itsci.mju.coopeducation_management_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itsci.mju.coopeducation_management_project.model.Student;
import itsci.mju.coopeducation_management_project.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	
	@Override
	public Student getStudentById(String studentId) {
		// TODO Auto-generated method stub
		return studentRepository.getReferenceById(studentId);
	}
	
	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student updateStudent) {
		// TODO Auto-generated method stub
		return studentRepository.save(updateStudent);
	}

	@Override
	public void deleteStudent(String studentId) {
		// TODO Auto-generated method stub
		Student student = studentRepository.getReferenceById(studentId);
		studentRepository.delete(student);
	}

//	@Override
//    public List<Student> findByCoopEduId(Long docId) {
//        return studentRepository.findByCoopEduId(docId);
//    }

	

}
