package itsci.mju.coopeducation_management_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import itsci.mju.coopeducation_management_project.model.Company;
import itsci.mju.coopeducation_management_project.service.CompanyService;

@Controller
@RestController
public class CompanyController {
	
	
	@Autowired
    private CompanyService companyService;

//	@GetMapping("/searchCompanies")
//    public String searchCompanies(@RequestParam("keyword") String keyword, Model model) {
//        List<Company> companies = companyService.searchCompaniesByKeyword(keyword);
//        model.addAttribute("companies", companies);
//        return "searchResult";  // ชื่อของหน้า JSP หรือหน้า HTML ที่จะแสดงผลการค้นหา
//    }

    @GetMapping("/companyId")
    public Company getCompanyById(@RequestParam("companyId") Long companyId) {
        return companyService.findById(companyId);
    }
    
}
