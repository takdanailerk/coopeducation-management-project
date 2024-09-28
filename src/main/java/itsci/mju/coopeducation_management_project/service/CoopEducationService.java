package itsci.mju.coopeducation_management_project.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import itsci.mju.coopeducation_management_project.model.CoopEducation;


public interface CoopEducationService {
	
//	void generatePdfReport();
	
	List<CoopEducation> getAllCoopEducations();
//	CoopEducation addCoopEducation(CoopEducation coopEducation);
	CoopEducation getCoopEducationById(Long coopEduId);
	CoopEducation updateCoopEducation(CoopEducation updateCoopEducation);
	void deleteCoopEducation (Long coopEduId);

	void addCoopEducation(Long majorId, Long companyId, Map<String, String> requestBody, List<String> studentNames,
			List<String> studentLastnames, List<String> studentIds, List<String> studentPhoneNos,
			List<String> studentEmails,List<MultipartFile>docNames,Model model) throws IOException;
	
//	InputStream generatePdfFromJson(Map<String, Object> jsonData);
	

//	ByteArrayInputStream generatePdf(String title, String content);
	
//	void addCoopEducation(Long majorId, Long companyId, Map<String, String> requestBody, List<String> studentNames,
//			List<String> studentLastnames, List<String> studentIds, List<String> studentPhoneNos,
//			List<String> studentEmails,
//			List<itsci.mju.coopeducation_management_project.service.MultipartFile> studentFiles);
}
