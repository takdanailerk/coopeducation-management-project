package itsci.mju.coopeducation_management_project.service;

import java.util.List;

import itsci.mju.coopeducation_management_project.model.AcceptanceStatus;
import itsci.mju.coopeducation_management_project.model.Document;

public interface AcceptanceStatusService {
	
	List<AcceptanceStatus> getAllAccaptances();
	AcceptanceStatus getAcceptanceById(Long acceptStatId);
	AcceptanceStatus addAcceptance(AcceptanceStatus acceptanceStatus);
	AcceptanceStatus updateAcceptance(AcceptanceStatus updateAcceptance);
	void deleteAcceptance (Long acceptStatId);
	AcceptanceStatus findById(Long acceptStatId);
	
	List<AcceptanceStatus> findByCoopEduId(Long coopEduId);
	
//	List<Document> findDocumentsByCoopEduId(Long coopEduId);
}
