package itsci.mju.coopeducation_management_project.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import itsci.mju.coopeducation_management_project.model.AcceptanceStatus;
import itsci.mju.coopeducation_management_project.model.Company;
import itsci.mju.coopeducation_management_project.model.CoopEducation;
import itsci.mju.coopeducation_management_project.model.Major;
import itsci.mju.coopeducation_management_project.model.Student;
import itsci.mju.coopeducation_management_project.repository.CoopEducationRepository;
import itsci.mju.coopeducation_management_project.service.AcceptanceStatusService;
import itsci.mju.coopeducation_management_project.service.CompanyService;
import itsci.mju.coopeducation_management_project.service.CoopEducationService;
import itsci.mju.coopeducation_management_project.service.DocumentService;
import itsci.mju.coopeducation_management_project.service.MajorService;
import itsci.mju.coopeducation_management_project.service.StudentService;

@Controller

@RequestMapping("/request-form")
public class RequestFormController {
	
	private static final Long Long = null;

	@Autowired
	private CoopEducationService coopEducationService;
	
	@Autowired
	private MajorService majorService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
    private StudentService studentService;
	
	@Autowired
	private AcceptanceStatusService acceptanceService;
	
	@Autowired
	private DocumentService documentService;

	@Autowired
	private CoopEducationRepository coopEducationRepository; 
	
	
	@GetMapping("/list-request-page")
	public String goToListCoopEducationPage (Model model) {
		
//		List<CoopEducation> coopEducations = coopEducationService.getAllCoopEducations();
//		Map<Long, List<Student>> studentsByCoopEduId = new HashMap<>();
//	    for (CoopEducation ce : coopEducations) {
//	        studentsByCoopEduId.put(ce.getCoopEduId(), ce.getStudents());
//	    }
		
//		List<CoopEducation> coop_educations = coopEducationRepository.findAllWithStudents();
		
		model.addAttribute("coop_educations", coopEducationService.getAllCoopEducations());
		model.addAttribute("companies", companyService.getAllCompanies());
		model.addAttribute("students", studentService.getAllStudents());
		model.addAttribute("documents", documentService.getAllDocuments());
		model.addAttribute("acceptance_status", acceptanceService.getAllAccaptances());
		
		return "list-request-form";
	}
	
	@GetMapping("/add-request-form-page")
	public String goToAddCoopEducationPage (Model model) {
		List<Major> majors = majorService.getAllMajors(); // ดึงข้อมูล Major ทั้งหมด
		List<Company> companies = companyService.getAllCompanies(); // ดึงข้อมูล Company ทั้งหมด
		List<AcceptanceStatus> acceptances = acceptanceService.getAllAccaptances(); // ดึงข้อมูล A ทั้งหมด

		model.addAttribute("acceptance_tatus", acceptances);
		model.addAttribute("majors", majors);
	    model.addAttribute("companies", companies);
		model.addAttribute("coop_educations", coopEducationService.getAllCoopEducations());
		return "add-request-form";
	}
	
	@GetMapping("/edit-request-page/{acceptStatId}")
	public String goToUpdateCoopEducationPage (Model model, @PathVariable String acceptStatId) {
		AcceptanceStatus acceptance = acceptanceService.getAcceptanceById(Long.valueOf(acceptStatId));
		CoopEducation coopEducation = coopEducationService.getCoopEducationById(Long.valueOf(acceptStatId));
		Major major = majorService.getMajorById(Long.valueOf(acceptStatId));
		Company company = companyService.getCompanyById(Long.valueOf(acceptStatId));
		Student student = studentService.getStudentById(acceptStatId);
		
		model.addAttribute("acceptance", new AcceptanceStatus());
		model.addAttribute("acceptance", acceptance);
		model.addAttribute("coop_education", coopEducation);
		model.addAttribute("major", major);
		model.addAttribute("companie", company);
		model.addAttribute("students", student);
		
		return "update-request-form";
	}
	
	@PostMapping("/add")
	public String AddCoopEducationForm (@RequestParam Long majorId, @RequestParam(value = "companyId", required = false) Long companyId, @RequestParam Map<String, String> requestBody,
			@RequestParam("studentName[]") List<String> studentNames,
            @RequestParam("studentLastname[]") List<String> studentLastnames,
            @RequestParam("studentId[]") List<String> studentIds,
            @RequestParam("studentPhoneNo[]") List<String> studentPhoneNos,
            @RequestParam("studentEmail[]") List<String> studentEmails,
            @RequestParam("docName[]") List<MultipartFile>docNames,
            Model model) throws IOException  {
		//check import file < 2 file
//		if (docNames.size() > 2) {
//	        throw new IllegalStateException("Cannot upload more than 2 files");
//	    }
		
		coopEducationService.addCoopEducation(majorId,companyId,requestBody,studentNames, studentLastnames, studentIds, studentPhoneNos, studentEmails,docNames,model);
		return "redirect:/request-form/add-request-form-page";
	}
	
	@PostMapping("/update/{acceptStatId}")
	public String UpdateCoopEducationForm (CoopEducation updateCoopEducation,AcceptanceStatus updateAcceptance,@PathVariable String acceptStatId) {
		acceptanceService.updateAcceptance(updateAcceptance);
		coopEducationService.updateCoopEducation(updateCoopEducation);
		return "redirect:/request-form/list-request-form-page";
	}
	
	@DeleteMapping("/delete/{acceptStatId}")
	public String DeleteCoopEducationForm (@PathVariable String acceptStatId) {
		acceptanceService.deleteAcceptance(Long.valueOf(acceptStatId));
		
//		coopEducationService.deleteCoopEducation(Long.valueOf(acceptStatId));
		return "redirect:/request-form/list-request-form-page";
	}
	
	@PostMapping("/checkStudentId")
    public ResponseEntity<Boolean> checkStudentId(@RequestParam String studentId) {
        Student existStudent = studentService.getStudentById(studentId);
        if (existStudent != null) {
            return ResponseEntity.ok(true); // studentId มีอยู่แล้ว
        } else {
            return ResponseEntity.ok(false); // studentId ไม่มี
        }
    }
	
}
