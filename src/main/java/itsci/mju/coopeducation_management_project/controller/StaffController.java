package itsci.mju.coopeducation_management_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import itsci.mju.coopeducation_management_project.model.Staff;
import itsci.mju.coopeducation_management_project.repository.StaffRepository;
import itsci.mju.coopeducation_management_project.service.StaffService;

@Controller
@RequestMapping("/")
public class StaffController {
	
	@Autowired
    private StaffService staffService;
	
	@Autowired
	private StaffRepository staffRepository;
	
	
//	@Autowired
//    private BCryptPasswordEncoder passwordEncoder;
	
	
//	@GetMapping("/home")
//	public String goToHomePage () {
//		return "home";
//	}
//	
	@GetMapping("/register-form")
    public String showRegistrationForm(Model model) {
        model.addAttribute("staff", new Staff());
        return "register-form";
    }
	
//	@PostMapping("/register")
//    public String registerStaff(@ModelAttribute("staff") Staff staff) {
//		staff.setPassword(passwordEncoder.encode(staff.getPassword()));
//	    staff.setRole("USER");
//        staffRepository.save(staff);
//        return "redirect:/login";
//    }
	
	
	
	
//	@GetMapping("/user/home")
//    public String userHome() {
//        return "user/home";
//    }

//    @GetMapping("/admin/home")
//    public String adminHome() {
//        return "admin/home";
//    }
    
	
}
