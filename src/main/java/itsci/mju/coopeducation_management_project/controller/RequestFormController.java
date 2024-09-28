package itsci.mju.coopeducation_management_project.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import itsci.mju.coopeducation_management_project.model.Document;
import itsci.mju.coopeducation_management_project.model.Major;
import itsci.mju.coopeducation_management_project.model.Student;
import itsci.mju.coopeducation_management_project.repository.CoopEducationRepository;
import itsci.mju.coopeducation_management_project.service.AcceptanceStatusService;
import itsci.mju.coopeducation_management_project.service.AcceptanceStatusServiceImpl;
import itsci.mju.coopeducation_management_project.service.CompanyService;
import itsci.mju.coopeducation_management_project.service.CoopEducationService;
import itsci.mju.coopeducation_management_project.service.CoopEducationServiceImpl;
import itsci.mju.coopeducation_management_project.service.DocumentService;
import itsci.mju.coopeducation_management_project.service.MajorService;
import itsci.mju.coopeducation_management_project.service.StudentService;


@Controller

@RequestMapping("/request-form")
public class RequestFormController {
	
	private static final Long Long = null;
	
//	private final String UPLOAD_DIR = "/path/to/upload/dir/";

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
	private AcceptanceStatusServiceImpl acceptanceServiceImpl;
	
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
		Map<Long, AcceptanceStatusServiceImpl.CoopEducationData> groupedAcceptanceStatuses = acceptanceServiceImpl.getGroupedAcceptanceStatuses();
        model.addAttribute("groupedAcceptanceStatuses", groupedAcceptanceStatuses);
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
	
	@GetMapping("/edit-request-page/{coopEduId}")
	public String goToUpdateCoopEducationPage (Model model, @PathVariable String coopEduId) {
//		AcceptanceStatus acceptance = acceptanceService.getAcceptanceById(Long.valueOf(coopEduId));
//		CoopEducation coopEducation = coopEducationService.getCoopEducationById(Long.valueOf(coopEduId));
//		Major major = majorService.getMajorById(Long.valueOf(coopEduId));
//		Company company = companyService.getCompanyById(Long.valueOf(coopEduId));
//		Student student = studentService.getStudentById(coopEduId);
//		
//		model.addAttribute("acceptance", new AcceptanceStatus());
//		model.addAttribute("acceptance", acceptance);
//		model.addAttribute("coop_education", coopEducation);
//		model.addAttribute("major", major);
//		model.addAttribute("companie", company);
//		model.addAttribute("students", student);
		
		// ดึงข้อมูล AcceptanceStatus ที่เกี่ยวข้องกับ coopEduId
        List<AcceptanceStatus> acceptanceStatuses = acceptanceService.findByCoopEduId(Long.valueOf(coopEduId));
        
        
//     // ดึงข้อมูล AcceptanceStatus ที่เกี่ยวข้องกับ coopEduId
//        List<CoopEducation> coopEducation = coopEducationService.getCoopEducationById(Long.valueOf(coopEduId));
        
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
		return "update-request-form";
	}
	
	
	@PostMapping("/add")
	public String AddCoopEducationForm (@RequestParam Long majorId, @RequestParam(value = "companyId", required = false) Long companyId, 
			@RequestParam Map<String, String> requestBody,
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
		
		 try {
	            coopEducationService.addCoopEducation(majorId, companyId, requestBody, studentNames, studentLastnames, studentIds, studentPhoneNos, studentEmails, docNames, model);
	            model.addAttribute("message", "การอัปโหลดสำเร็จ");
	            return "redirect:/request-form/add-request-form-page"; // เปลี่ยนเป็นชื่อ view ที่คุณต้องการแสดง
	        } catch (IOException e) {
	            e.printStackTrace();
	            model.addAttribute("message", "การอัปโหลดล้มเหลว");
	            return "redirect:/request-form/add-request-form-page"; // เปลี่ยนเป็นชื่อ view ที่คุณต้องการแสดงเมื่อเกิดข้อผิดพลาด
	        }
	}
	
	
	@PostMapping("/update/{acceptStatId}")
	public String UpdateCoopEducationForm (CoopEducation updateCoopEducation,AcceptanceStatus updateAcceptance
			,Company updateCompany,@PathVariable String acceptStatId) {
		acceptanceService.updateAcceptance(updateAcceptance);
		coopEducationService.updateCoopEducation(updateCoopEducation);
		companyService.updateCompany(updateCompany);
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
	
	
	@GetMapping("/edit-request-page/{coopEduId}/edit-student-page/{studentId}")
	public String goToUpdateStudentPage (Model model, @PathVariable String coopEduId,@PathVariable String studentId) {
		
		Student student = studentService.getStudentById(studentId);
		
		// ดึงข้อมูล AcceptanceStatus ที่เกี่ยวข้องกับ coopEduId
//        List<AcceptanceStatus> acceptanceStatuses = acceptanceService.findByCoopEduId(Long.valueOf(acceptStatId));
        AcceptanceStatus acceptanceStatus = acceptanceService.getAcceptanceById(Long.valueOf(coopEduId));
        CoopEducation coopEducation = acceptanceStatus.getCoopEducation();
        
        model.addAttribute("coopEducation", coopEducation);
		model.addAttribute("acceptances", acceptanceStatus);
        model.addAttribute("students", student);
		return "edit-student";
	}
	
	
	@PostMapping("/edit-request-page/{coopEduId}/edit-student-page/update/{studentId}")
	public String UpdateStudent(@PathVariable String coopEduId,@PathVariable String studentId,@ModelAttribute("acceptances") AcceptanceStatus acceptances) {
	    Student updateStudent = acceptances.getStudent();
	    updateStudent.setStudentId(studentId);
	    studentService.updateStudent(updateStudent);
		return "redirect:/request-form/edit-request-page/" + coopEduId;
	}
	
	@GetMapping("/download/{filePath}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String filePath) {
	    Path path = Paths.get("/path/to/upload/dir/").resolve(filePath);
	    Resource resource = new FileSystemResource(path);

	    if (resource.exists() || resource.isReadable()) {
	        return ResponseEntity.ok()
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
	            .body(resource);
	    } else {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
	}
	
}
