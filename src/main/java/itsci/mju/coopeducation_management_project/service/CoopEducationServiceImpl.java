package itsci.mju.coopeducation_management_project.service;

import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

//import com.itextpdf.io.font.constants.StandardFonts;
//import com.itextpdf.kernel.font.PdfFont;
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;

//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;
//import org.springframework.stereotype.Service;

import itsci.mju.coopeducation_management_project.model.AcceptanceStatus;
import itsci.mju.coopeducation_management_project.model.Company;
import itsci.mju.coopeducation_management_project.model.CoopEducation;
import itsci.mju.coopeducation_management_project.model.Document;
import itsci.mju.coopeducation_management_project.model.Major;
import itsci.mju.coopeducation_management_project.model.Student;
import itsci.mju.coopeducation_management_project.repository.AcceptanceRepository;
import itsci.mju.coopeducation_management_project.repository.CompanyRepository;
import itsci.mju.coopeducation_management_project.repository.CoopEducationRepository;
import itsci.mju.coopeducation_management_project.repository.DocumentRepository;
import itsci.mju.coopeducation_management_project.repository.MajorRepository;
import itsci.mju.coopeducation_management_project.repository.StudentRepository;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Service
public class CoopEducationServiceImpl implements CoopEducationService{

	private static final String UPLOAD_DIR = "";

	@Autowired
	private CoopEducationRepository coopEducationRepository;
	
//	@Autowired
//	private CoopEducationService coopEducationService;
	
	@Autowired
	private MajorRepository majorRepository;
	
	@Autowired
	private MajorService majorService;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentService studentService;
	
	
	@Autowired
	private AcceptanceStatusService acceptanceService;
	
	
	@Autowired
	private AcceptanceRepository acceptanceRepository;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired
	private DocumentService documentService;
	
	
	@Override
	public List<CoopEducation> getAllCoopEducations() {
		// TODO Auto-generated method stub
		return coopEducationRepository.findAll();
	}

	@Override
	public CoopEducation getCoopEducationById(Long coopEduId) {
		// TODO Auto-generated method stub
		return coopEducationRepository.getReferenceById(coopEduId);
	}

	
	@Override
	public void addCoopEducation(Long majorId,Long companyId,@RequestParam Map<String, String> requestBody,List<String> studentNames, List<String> studentLastnames,
            List<String> studentIds, List<String> studentPhoneNos, List<String> studentEmails , List<MultipartFile>docNames	,Model model) throws IOException {
		// TODO Auto-generated method stub
		        
				//add company---------------------------------------------------
				if(companyId == null || companyId == 0) {
					companyId = ((companyRepository.getMaxCompanyId() == null )? 0 : companyRepository.getMaxCompanyId()) + 1;
				}
				
				String companyIdStr = requestBody.get("companyId");
			    // ตรวจสอบว่า companyIdStr ไม่ใช่ค่าว่างหรือ null ก่อนแปลงเป็น Long
//			    Long companyIdr = null;
			    if (companyIdStr != null && !companyIdStr.isEmpty()) {
			        try {
			            companyId = Long.parseLong(companyIdStr);
			        } catch (NumberFormatException e) {
			            // จัดการกับกรณีที่แปลงค่าเป็น Long ไม่สำเร็จ
			            System.out.println("Invalid companyId: " + companyIdStr);
			        }
			    }

				String companyName = requestBody.get("companyName");
				String companyPhoneNo = requestBody.get("companyPhoneNo");
				String companyEmail = requestBody.get("companyEmail");
				String companyLine = requestBody.get("companyLine");
				String companyFacebook = requestBody.get("companyFacebook");
				String coordinatorName = requestBody.get("coordinatorName");
				String coordinatorPhoneNo = requestBody.get("coordinatorPhoneNo");
	
				Company company = new Company();
				company.setCompanyId(companyId);
				company.setCompanyName(companyName);
				company.setCompanyAddress(companyLine);
				company.setCompanyPhoneNo(companyPhoneNo);
				company.setCompanyEmail(companyEmail);
				company.setCompanyLine(companyLine);
				company.setCompanyFacebook(companyFacebook);
				company.setCoordinatorName(coordinatorName);
				company.setCoordinatorPhoneNo(coordinatorPhoneNo);

				// บันทึก Company และรับ companyId
				companyService.addCompany(company);
				// ค้นหา Company ที่ถูกบันทึก
				Company existCompany = companyService.getCompanyById(companyId);
				
			
			    		
		//add coopEducation------------------------------------------------
		
		Long coopEduId = ((coopEducationRepository.getMaxCoopEduId() == null )? 0 : coopEducationRepository.getMaxCoopEduId()) + 1;
		String coopName = requestBody.get("coopName");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // กำหนดรูปแบบของวันที่ที่คาดว่าจะได้รับ
        LocalDate startDateLocalDate = LocalDate.parse(requestBody.get("startDate"), formatter);// แปลง String เป็น LocalDate
        LocalDate endDateLocalDate = LocalDate.parse(requestBody.get("endDate"), formatter);
        LocalDateTime startDateTime = startDateLocalDate.atTime(LocalTime.now());// ผสม LocalDate กับเวลาปัจจุบัน (LocalTime.now())
        LocalDateTime endDateTime = endDateLocalDate.atTime(LocalTime.now());
        Date startDate = Date.from(startDateTime.atZone(ZoneId.systemDefault()).toInstant()); // แปลง LocalDate เป็น Date
        Date endDate = Date.from(endDateTime.atZone(ZoneId.systemDefault()).toInstant());
		
		String coopEduType = requestBody.get("coopEduType");
		String status = requestBody.get("status");
		String coopEduYear = requestBody.get("coopEduYear");
		String coopEduSemester = requestBody.get("coopEduSemester");
		Major major = majorService.getMajorById(majorId);
		
		
		CoopEducation coopEducation = new CoopEducation();
		coopEducation.setCoopEduId(coopEduId);
		coopEducation.setCoopName("ขอความอนุเคราะห์");
		coopEducation.setStartDate(startDate);
		coopEducation.setEndDate(endDate);
		coopEducation.setCoopEduType(coopEduType);
		coopEducation.setStatus("รอเจ้าหน้าที่ตรวจสอบเอกสาร");
		coopEducation.setCoopEduYear(coopEduYear);
		coopEducation.setCoopEduSemester(coopEduSemester);
		coopEducation.setCompany(existCompany);
		coopEducation.setMajor(major);
		coopEducationRepository.save(coopEducation);
		

		
		int studentIndex = 0;
//		int filesPerStudent = docNames.size() / studentNames.size();
		
		int filesPerStudent = docNames.size() / studentIds.size();
		int fileIndex = 0; 
		
		for (int i = 0; i < studentIds.size(); i++) {
		    Student student = new Student();
		    student.setStudentName(studentNames.get(i));
		    student.setStudentLastname(studentLastnames.get(i));
		    student.setStudentId(studentIds.get(i));
		    student.setStudentPhoneNo(studentPhoneNos.get(i));
		    student.setStudentEmail(studentEmails.get(i));

		    // บันทึกนักเรียน
		    studentService.addStudent(student);

		    Student existStudent = studentService.getStudentById(studentIds.get(i));

		    // จัดการไฟล์ที่สัมพันธ์กับนักเรียนคนนี้
		    for (int j = 0; j < filesPerStudent; j++) {
		        if (fileIndex < docNames.size()) {
		            MultipartFile file = docNames.get(fileIndex++);
		            if (!file.isEmpty()) {
		                // บันทึกไฟล์ไปยังเซิร์ฟเวอร์
		                String filePath = UPLOAD_DIR + file.getOriginalFilename();
		                File serverFile = new File(filePath);
		                file.transferTo(serverFile);

		                // สร้างและบันทึก Document
		                Document document = new Document();
		                document.setDocName(file.getOriginalFilename());
		                document.setUploadDate(new java.sql.Date(new Date().getTime())); // บันทึกวันที่ปัจจุบัน
		                document.setDocType(file.getContentType());
		                document.setFilePath(filePath); // เก็บ path ของไฟล์ที่บันทึก
		                document.setStudent(existStudent);  // สมมติว่าคุณมี student entity ที่กำหนดไว้แล้ว

		                // บันทึก document ลงในฐานข้อมูล
		                documentService.addDocument(document);
		            }
		        }
		    }
		    
		    Long acceptStatId = ((acceptanceRepository.getMaxAcceptenceId() == null )? 0 : acceptanceRepository.getMaxAcceptenceId()) + 1;
    		String acceptStatus =  requestBody.get("acceptStatus");

    		AcceptanceStatus acceptance = new AcceptanceStatus();
    		acceptance.setAcceptStatId(acceptStatId);
    		acceptance.setAcceptStatus("กำลังจัดส่งเอกสาร");
    		acceptance.setCoopEducation(coopEducation);
    		acceptance.setStudent(existStudent);
    		acceptanceRepository.save(acceptance);
    	    }
		}
		
	
	
		
//		for (int i = 0; i < studentIds.size(); i++) {
//            Student student = new Student();
//            student.setStudentName(studentNames.get(i));
//		    student.setStudentLastname(studentLastnames.get(i));
//		    student.setStudentId(studentIds.get(i));
//		    student.setStudentPhoneNo(studentPhoneNos.get(i));
//		    student.setStudentEmail(studentEmails.get(i));
//
//
////            // บันทึกนักเรียน
////            studentService.addStudent(student);
//
//            Student existStudent = studentService.getStudentById(studentIds.get(i));
//            // จัดการไฟล์สำหรับนักเรียนแต่ละคน
////            List<MultipartFile> docName = (List<MultipartFile>) docNames.get(i);
//            
//            for (MultipartFile file : docNames) { // วนลูปผ่าน docNames โดยตรง
//                if (!file.isEmpty()) {
//                    // บันทึกไฟล์ไปยังเซิร์ฟเวอร์
//                    String filePath = UPLOAD_DIR + file.getOriginalFilename();
//                    File serverFile = new File(filePath);
//                    file.transferTo(serverFile);
//
//                    // สร้างและบันทึก Document
//                    Document document = new Document();
//                    document.setDocName(file.getOriginalFilename());
//                    document.setUploadDate(new java.sql.Date(new Date().getTime())); // บันทึกวันที่ปัจจุบัน
//                    document.setDocType(file.getContentType());
//                    document.setFilePath(filePath); // เก็บ path ของไฟล์ที่บันทึก
//                    document.setStudent(student);  // สมมติว่าคุณมี student entity ที่กำหนดไว้แล้ว
//
//                    // บันทึก document ลงในฐานข้อมูล
//                    documentService.addDocument(document);
//                }
//            }
//            Long acceptStatId = ((acceptanceRepository.getMaxAcceptenceId() == null )? 0 : acceptanceRepository.getMaxAcceptenceId()) + 1;
//    		String acceptStatus =  requestBody.get("acceptStatus");
//
//    		AcceptanceStatus acceptance = new AcceptanceStatus();
//    		acceptance.setAcceptStatId(acceptStatId);
//    		acceptance.setAcceptStatus("กำลังจัดส่งเอกสาร");
//    		acceptance.setCoopEducation(coopEducation);
//    		acceptance.setStudent(existStudent);
//    		acceptanceRepository.save(acceptance);
//    	    }
//        }

		
        
        
//		for (int i = 0; i < studentNames.size(); i++) {
//		    Student student = new Student();
//		    student.setStudentName(studentNames.get(i));
//		    student.setStudentLastname(studentLastnames.get(i));
//		    student.setStudentId(studentIds.get(i));
//		    student.setStudentPhoneNo(studentPhoneNos.get(i));
//		    student.setStudentEmail(studentEmails.get(i));
//		    studentService.addStudent(student);
//		    
//		    // Fetch the student just saved or already existing
//		    Student existStudent = studentService.getStudentById(studentIds.get(i));
//		    
//		    // Process documents for the current student
//		    int MAX_FILE_SIZE = 100 * 1024 * 1024; // 100 MB
////		    Long maxDocId = ((documentRepository.getMaxDocId() == null) ? 0 : documentRepository.getMaxDocId()) + 1;
//
//		    // Loop through the documents associated with this student
//		    for (int j = studentIndex; j < docNames.size(); j++) {
//		        MultipartFile file = docNames.get(j);
//		        
////		        if (file.getSize() > MAX_FILE_SIZE) {
////		            throw new IllegalStateException("File size exceeds the maximum limit");
////		        }
////		        // Save the document
////		        Document document = new Document();
//////		        Long docId = ++maxDocId; // Increment docId for each new document
//////		        document.setDocId(docId);
////		        document.setDocName(file.getOriginalFilename());
////		        document.setUploadDate(new java.sql.Date(new Date().getTime()));
////		        document.setDocType(file.getContentType());
////		        document.setFileData(file.getBytes());
////		        document.setStudent(existStudent);
////		        documentRepository.save(document);
//		        
//		     // If this is the last document for the current student, update the index and break the loop
//		        if ((j + 1) % (docNames.size() / studentNames.size()) == 0) {
//		            studentIndex = j + 1; // Update the index for the next student
//		            break; // Exit the inner loop to move on to the next student
//		        }
//			}
		    
//		      add acceptStatus------------------------------------------------

		   
		

	// เมธอดแปลงวันที่เป็นรูปแบบไทย
    public static String formatThaiDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR) + 543; // เพิ่ม 543 ปีเพื่อแปลงเป็นปี พ.ศ.
        int month = calendar.get(Calendar.MONTH) + 1; // เดือนเริ่มต้นที่ 0
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy", new Locale("th", "TH"));
        String thaiDate = sdf.format(calendar.getTime());
        
        return thaiDate;
    }

    
	@Override
	public CoopEducation updateCoopEducation(CoopEducation updateCoopEducation) {
		// TODO Auto-generated method stub
		return coopEducationRepository.save(updateCoopEducation);
	}

	@Override
	public void deleteCoopEducation(Long coopEduId) {
		// TODO Auto-generated method stub
		//acceptanceRepository.deleteByCoopEduId(coopEduId);
	    coopEducationRepository.deleteById(coopEduId);
		
	}
	
	

//	@Override
//    public InputStream generatePdfFromJson(Map<String, Object> jsonData) {
//        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
//            PdfWriter writer = new PdfWriter(out);
//            PdfDocument pdfDoc = new PdfDocument(writer);
//            Document document = new Document(pdfDoc);
//
//            // เพิ่มข้อมูลจาก JSON ลงใน PDF
//            for (Map.Entry<String, Object> entry : jsonData.entrySet()) {
//                document.add(new Paragraph(entry.getKey() + ": " + entry.getValue()));
//            }
//
//            document.close();
//            return new ByteArrayInputStream(out.toByteArray());
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
	
//	 @Override
//	    public ByteArrayInputStream generatePdf(String title, String content) {
//	        Document document = new Document();
//	        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//	        try {
//	            PdfWriter.getInstance(document, out);
//	            document.open();
//
//	            // กำหนดรูปแบบฟอนต์สำหรับเอกสารราชการ
//	            Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
//
//	            // สร้าง Title สำหรับเอกสาร
//	            Paragraph titleParagraph = new Paragraph(title, font);
//	            titleParagraph.setAlignment(Element.ALIGN_CENTER);
//	            document.add(titleParagraph);
//
//	            // เว้นระยะบรรทัด
//	            document.add(new Paragraph(" "));
//
//	            // เพิ่มเนื้อหาในเอกสาร
//	            Paragraph contentParagraph = new Paragraph(content, font);
//	            document.add(contentParagraph);
//
//	            document.close();
//
//	        } catch (DocumentException e) {
//	            e.printStackTrace();
//	        }
//
//	        return new ByteArrayInputStream(out.toByteArray());
//	    }
	}
	
