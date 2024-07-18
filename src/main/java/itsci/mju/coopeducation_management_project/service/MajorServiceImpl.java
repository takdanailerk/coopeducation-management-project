package itsci.mju.coopeducation_management_project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itsci.mju.coopeducation_management_project.model.Major;
import itsci.mju.coopeducation_management_project.repository.MajorRepository;

@Service
public class MajorServiceImpl implements MajorService {

	@Autowired
	private MajorRepository majorRepository;
	
	@Override
	public List<Major> getAllMajors() {
		return majorRepository.findAll();
	}
	
	@Override
	public Major getMajorById(Long majorId) {
		return majorRepository.getReferenceById(majorId);
	}

	@Override
	public Major addMajor(Map<String, String> requestBody) {
		Long majorId = ((majorRepository.getMaxMajorId() == null)? 0 : majorRepository.getMaxMajorId()) + 1;
		String majorName = requestBody.get("majorName");
		String majorPhoneNo = requestBody.get("majorPhoneNo");
		String majorFax = requestBody.get("majorFax");
		String majorEmail = requestBody.get("majorEmail");
		Major major = new Major(majorId, majorName, majorPhoneNo, majorFax, majorEmail);
		return majorRepository.save(major);
	}

	@Override
	public Major updateMajor(Major updatedMajor) {
		// TODO Auto-generated method stub
		return majorRepository.save(updatedMajor);
	}
	
	@Override
	public void deleteMajor(Long majorId) {
		Major major = majorRepository.getReferenceById(majorId);
		majorRepository.delete(major);
	}

}
