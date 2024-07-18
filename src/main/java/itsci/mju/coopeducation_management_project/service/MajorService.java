package itsci.mju.coopeducation_management_project.service;

import java.util.List;
import java.util.Map;

import itsci.mju.coopeducation_management_project.model.Major;

public interface MajorService {

	List<Major> getAllMajors();
	Major getMajorById(Long majorId);
	Major addMajor(Map<String, String> requestBody);
	Major updateMajor(Major updatedMajor);
	void deleteMajor(Long majorId);
	
}
