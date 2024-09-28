package itsci.mju.coopeducation_management_project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itsci.mju.coopeducation_management_project.model.AcceptanceStatus;
import itsci.mju.coopeducation_management_project.model.CoopEducation;
import itsci.mju.coopeducation_management_project.model.Document;
import itsci.mju.coopeducation_management_project.repository.AcceptanceRepository;
import itsci.mju.coopeducation_management_project.repository.CoopEducationRepository;


@Service
public class AcceptanceStatusServiceImpl implements AcceptanceStatusService{

	@Autowired
    private AcceptanceRepository acceptanceRepository;
	
	@Autowired
    private CoopEducationRepository coopEducationRepository;

//    public Map<Long, CoopEducationData> getGroupedAcceptanceStatuses() {
//    	List<AcceptanceStatus> acceptanceStatuses = acceptanceRepository.findAll();
//        
//        return acceptanceStatuses.stream().collect(Collectors.groupingBy(
//            as -> as.getCoopEducation().getCoopEduId(),
//            Collectors.collectingAndThen(
//                Collectors.toList(),
//                list -> {
//                    CoopEducation coopEducation = list.get(0).getCoopEducation();
//                    
//                    // Get unique student names and their documents
//                    Map<String, List<Document>> studentDocumentsMap = list.stream()
//                        .collect(Collectors.groupingBy(
//                            as -> as.getStudent().getStudentId(),
//                            Collectors.flatMapping(
//                                as -> as.getStudent().getDocuments().stream(),
//                                Collectors.toList()
//                            )
//                        ));
//                    
//                    List<String> studentNames = list.stream()
//                        .map(as -> as.getStudent().getStudentName())
//                        .distinct()
//                        .collect(Collectors.toList());
//                    
//                    List<String> studentLastnames = list.stream()
//                            .map(as -> as.getStudent().getStudentLastname())
//                            .distinct()
//                            .collect(Collectors.toList());
//                    
//                    List<AcceptanceStatus> acceptanceStatusList = new ArrayList<>(list);

//                    return new CoopEducationData(coopEducation, studentNames,studentLastnames, studentDocumentsMap, acceptanceStatusList);
//                }
//            )
//        ));
//        
//    }
	
	public Map<Long, CoopEducationData> getGroupedAcceptanceStatuses() {
	    List<AcceptanceStatus> acceptanceStatuses = acceptanceRepository.findAll();

	    return acceptanceStatuses.stream().collect(Collectors.groupingBy(
	        as -> as.getCoopEducation().getCoopEduId(),
	        Collectors.collectingAndThen(
	            Collectors.toList(),
	            list -> {
	                CoopEducation coopEducation = list.get(0).getCoopEducation();

	                // Group by studentId and get documents (filePaths) for each unique student
	                Map<String, List<String>> studentDocuments = list.stream()
	                    .collect(Collectors.groupingBy(
	                        as -> as.getStudent().getStudentId(),
	                        Collectors.collectingAndThen(
	                            Collectors.flatMapping(
	                                as -> as.getStudent().getDocuments().stream().map(Document::getFilePath),
	                                Collectors.toList()
	                            ),
	                            docs -> docs.stream().distinct().collect(Collectors.toList()) // filter out duplicate file paths
	                        )
	                    ));

	                	List<String> studentNames = list.stream()
	                        .map(as -> as.getStudent().getStudentName())
	                        .distinct()
	                        .collect(Collectors.toList());
	                    
	                    List<String> studentLastnames = list.stream()
	                            .map(as -> as.getStudent().getStudentLastname())
	                            .distinct()
	                            .collect(Collectors.toList());
	                    
	                    List<AcceptanceStatus> acceptanceStatusList = new ArrayList<>(list);


	                // Return the CoopEducationData with student names and their documents (file paths)
	                return new CoopEducationData(coopEducation, studentNames,studentLastnames , studentDocuments, acceptanceStatusList);	            }
	        )
	    ));
	}

    public static class CoopEducationData {
    	private CoopEducation coopEducation;
        private List<String> studentNames;
        private List<String> studentLastnames;
        private Map<String, List<String>> studentDocuments;
        private List<AcceptanceStatus> acceptanceStatuses;

        public CoopEducationData(CoopEducation coopEducation, List<String> studentNames 
        						,List<String> studentLastnames, Map<String, List<String>> studentDocumentsMap, 
                                 List<AcceptanceStatus> acceptanceStatuses) {
            this.coopEducation = coopEducation;
            this.studentNames = studentNames;
            this.studentLastnames = studentLastnames;
            this.studentDocuments = studentDocumentsMap;
            this.acceptanceStatuses = acceptanceStatuses;
        }

        public CoopEducation getCoopEducation() {
            return coopEducation;
        }

        public List<String> getStudentNames() {
            return studentNames;
        }
        
        public List<String> getStudentLastnames() {
            return studentLastnames;
        }

        public void setStudentLastnames(List<String> studentLastnames) {
            this.studentLastnames = studentLastnames;
        }
        
        public List<AcceptanceStatus> getAcceptanceStatus() {
            return acceptanceStatuses;
        }

    }
    
    @Override
    public List<AcceptanceStatus> findByCoopEduId(Long coopEduId) {
        return acceptanceRepository.findByCoopEducation_CoopEduId(coopEduId);
    }
    
//    @Override
//    public List<Document> findDocumentsByCoopEduId(Long coopEduId) {
//        return acceptanceRepository.findDocuments_ByCoopEduId(coopEduId);
//    }
    
//    @Override
//	public List<AcceptanceStatus> findByCoopEduId(String coopEduId) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
    
	@Override
	public List<AcceptanceStatus> getAllAccaptances() {
		// TODO Auto-generated method stub
		return acceptanceRepository.findAll();
	}

	@Override
	public AcceptanceStatus getAcceptanceById(Long acceptStatId) {
		// TODO Auto-generated method stub
		return acceptanceRepository.getReferenceById(acceptStatId);
	}

	@Override
	public AcceptanceStatus addAcceptance(AcceptanceStatus acceptanceStatus) {
		// TODO Auto-generated method stub
		return acceptanceRepository.save(acceptanceStatus);
	}

	@Override
	public AcceptanceStatus updateAcceptance(AcceptanceStatus updateAcceptance) {
		// TODO Auto-generated method stub
		return acceptanceRepository.save(updateAcceptance);
	}

	@Override
	public void deleteAcceptance(Long acceptStatId) {
		// TODO Auto-generated method stub
		// หา AcceptanceStatus ที่ต้องการลบ
        AcceptanceStatus acceptance = acceptanceRepository.findById(acceptStatId)
		.orElseThrow(() -> new IllegalArgumentException("Invalid acceptStatId: " + acceptStatId));
		
        // หา CoopEducation ที่เกี่ยวข้อง
        CoopEducation coopEducation = acceptance.getCoopEducation();
//        acceptance.setStudent(null);
//        acceptance.setCoopEducation(null);
        acceptanceRepository.save(acceptance);
        // ลบ AcceptanceStatus
        acceptanceRepository.delete(acceptance);
        
        // ลบ CoopEducation ที่เกี่ยวข้อง (ถ้าต้องการ)
        if (coopEducation != null) {
            coopEducationRepository.delete(coopEducation);
        }
	}

	@Override
	public AcceptanceStatus findById(Long acceptStatId) {
		// TODO Auto-generated method stub
		return acceptanceRepository.findById(acceptStatId).orElse(null);
	}

	
}
