package itsci.mju.coopeducation_management_project.service;

import java.util.List;
import java.util.Map;

import itsci.mju.coopeducation_management_project.model.Major;

public interface MajorService {

	List<Major> getAllMajors();
	Major getMajorById(Long majorId);
	void addMajor(Map<String, String> requestBody);
//	void updateMajorAndStaff(Map<String, String> requestParams);
	void deleteMajor(Long majorId);
	Major updateMajor(Major updateMajor);
	
//	Staff getStaffById(Long staffId);
//    void updateMajor(Long staffId, Staff staff);
//	
}
