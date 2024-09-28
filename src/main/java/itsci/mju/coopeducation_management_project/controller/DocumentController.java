package itsci.mju.coopeducation_management_project.controller;

import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import itsci.mju.coopeducation_management_project.model.Document;
import itsci.mju.coopeducation_management_project.repository.DocumentRepository;
import itsci.mju.coopeducation_management_project.service.DocumentService;

@Controller
public class DocumentController {

	
	@Autowired
    private DocumentService documentService;
	
	@Autowired
    private DocumentRepository documentRepository;
	
	
	
	
	
	
//	@GetMapping("/download-document/{docId}")
//    public String getDocumentsByStudentId(@PathVariable Long docId, Model model) {
//        Document documents = documentService.findById(docId);
//        model.addAttribute("documents", documents);
//        return "documents";
//    }
//	
//	@GetMapping("/download-document/{docId}")
//    public ResponseEntity<byte[]> downloadDocument(@PathVariable Long docId) {
//    	Document document = documentRepository.findById(docId).orElseThrow(() -> new RuntimeException("Document not found"));
//        byte[] fileContent = document.getFileData();
//        
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.parseMediaType(document.getDocType()));
//        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(document.getDocName()).build());
//    	    
//    	    return new ResponseEntity<>(document.getFileData(), headers, HttpStatus.OK);
    	
    	
//    	Document document = documentService.findById(docId);
//    	// ใช้ชื่อเต็มของคลาสเพื่อหลีกเลี่ยงการชนกัน
//        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
//        headers.add("Content-Disposition", "attachment; filename=\"" + document.getDocName() + "\"");
//        
//        return ResponseEntity.ok()
//                .headers(headers)
//                .contentType(MediaType.parseMediaType(document.getDocType()))
//                .body(document.getFileData());
    	
    	
    	
//        List<Document> documents = documentService.findDocumentsByStudentId(studentId);
//        
//        if (documents != null && !documents.isEmpty()) {
//            Document document = documents.get(0); // ดาวน์โหลดไฟล์แรก (หรือคุณอาจต้องการให้ผู้ใช้เลือกไฟล์)
//            return ResponseEntity.ok()
//            		.header("Content-Disposition", "attachment; filename=\"" + document.getDocName() + "\"")
//                    .body(document.getFileData());
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }
	
}
