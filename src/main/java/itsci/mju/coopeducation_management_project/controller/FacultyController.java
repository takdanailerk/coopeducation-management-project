package itsci.mju.coopeducation_management_project.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import itsci.mju.coopeducation_management_project.model.AcceptanceStatus;
import itsci.mju.coopeducation_management_project.model.Company;
import itsci.mju.coopeducation_management_project.model.CoopEducation;
import itsci.mju.coopeducation_management_project.model.Document;
import itsci.mju.coopeducation_management_project.model.Major;
import itsci.mju.coopeducation_management_project.model.Student;
import itsci.mju.coopeducation_management_project.service.AcceptanceStatusService;
import itsci.mju.coopeducation_management_project.service.AcceptanceStatusServiceImpl;
import itsci.mju.coopeducation_management_project.service.CompanyService;
import itsci.mju.coopeducation_management_project.service.CoopEducationService;
import itsci.mju.coopeducation_management_project.service.CoopEducationServiceImpl;
import itsci.mju.coopeducation_management_project.service.DocumentService;
import itsci.mju.coopeducation_management_project.service.MajorService;
import itsci.mju.coopeducation_management_project.service.PdfService;
import itsci.mju.coopeducation_management_project.service.StudentService;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

	
	@Autowired
	private CoopEducationService coopEducationService;
	
	@Autowired
	private PdfService pdfService;
	
	@Autowired
	private MajorService majorService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
    private StudentService studentService;
	
	@Autowired
	private AcceptanceStatusService acceptanceService;
	
	@Autowired
	private AcceptanceStatusServiceImpl acceptanceServiceImpl;
	
	@Autowired
	private DocumentService documentService;
	
	
	@GetMapping("/list-coopeducation-page")
	public String goToListCoopEducationPage (Model model) {
		model.addAttribute("coop_educations", coopEducationService.getAllCoopEducations());
		model.addAttribute("companies", companyService.getAllCompanies());
		model.addAttribute("students", studentService.getAllStudents());
		model.addAttribute("documents", documentService.getAllDocuments());
		model.addAttribute("acceptance_status", acceptanceService.getAllAccaptances());
		Map<Long, AcceptanceStatusServiceImpl.CoopEducationData> groupedAcceptanceStatuses = acceptanceServiceImpl.getGroupedAcceptanceStatuses();
        model.addAttribute("groupedAcceptanceStatuses", groupedAcceptanceStatuses);
		return "faculty/list-coopeducation";
	}
	
	@GetMapping("/view-coop-requestform-detail-page/{coopEduId}")
	public String goToUpdateCoopEducationPage (Model model, @PathVariable String coopEduId) {
		// ดึงข้อมูล AcceptanceStatus ที่เกี่ยวข้องกับ coopEduId
        List<AcceptanceStatus> acceptanceStatuses = acceptanceService.findByCoopEduId(Long.valueOf(coopEduId));
        
        // ดึง CoopEducation เพื่อเอา coopName
        CoopEducation coopEducation = acceptanceStatuses.isEmpty() ? null : acceptanceStatuses.get(0).getCoopEducation();

        Document documents = documentService.getDocumentById(Long.valueOf(coopEduId));
     // ดึงข้อมูล Student ที่เกี่ยวข้องกับ coopEduId
//        List<Student> students = studentService.findByCoopEduId(Long.valueOf(coopEduId));

        
        String formattedStartDate = CoopEducationServiceImpl.formatThaiDate(coopEducation.getStartDate());
        String formattedEndDate = CoopEducationServiceImpl.formatThaiDate(coopEducation.getEndDate());

        model.addAttribute("formattedStartDate", formattedStartDate);
        model.addAttribute("formattedEndDate", formattedEndDate);
        
        model.addAttribute("coopEducation", coopEducation);
        model.addAttribute("acceptanceStatuses", acceptanceStatuses);
//        model.addAttribute("students", students);
//        model.addAttribute("studentDocumentsMap", studentDocumentsMap);
        model.addAttribute("documents", documents);
		return "faculty/coop-requestform-detail";
	}
	
	@PostMapping("/update/{acceptStatId}")
	public String UpdateCoopEducationForm (CoopEducation updateCoopEducation,AcceptanceStatus updateAcceptance,@PathVariable String acceptStatId) {
		acceptanceService.updateAcceptance(updateAcceptance);
		coopEducationService.updateCoopEducation(updateCoopEducation);
		return "redirect:/request-form/list-request-form-page";
	}
	
	@GetMapping("/delete/{coopEduId}")
	public String DeleteCoopEducationForm (@PathVariable String coopEduId) {
		coopEducationService.deleteCoopEducation(Long.valueOf(coopEduId));
		return "redirect:/request-form/list-request-form-page";
	}
	
	@GetMapping("/generate-pdf")
    public ResponseEntity<InputStreamResource> exportPdf() {
        ByteArrayInputStream bis = pdfService.generatePdfReport();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
	
//	@PostMapping(value = "/generate-pdf", produces = MediaType.APPLICATION_PDF_VALUE)
//    public ResponseEntity<byte[]> generatePdf(@RequestBody Map<String, Object> jsonData) throws IOException {
//        InputStream pdfStream = coopEducationService.generatePdfFromJson(jsonData);
//
//        byte[] pdfBytes = pdfStream.readAllBytes();
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=output.pdf");
//
//        return ResponseEntity.ok()
//                .headers(headers)
//                .contentType(MediaType.APPLICATION_PDF)
//                .body(pdfBytes);
//    }
	
}
