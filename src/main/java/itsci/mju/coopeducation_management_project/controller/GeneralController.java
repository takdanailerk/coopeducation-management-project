package itsci.mju.coopeducation_management_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import itsci.mju.coopeducation_management_project.model.Staff;

@Controller
public class GeneralController {

	
	@GetMapping("/login")
	public String goToLonginPage () {
		return "login";
	}
	
	
//	@GetMapping("/home")
//	public String goToHomePage () {
//		return "home";
//	}
	
	
//	@PostMapping("/login")
//	public String showHomePage(Model model) {
//      return "redirect:/home";
//  }
	
	@GetMapping("/view-status")
	public String goToViewStatusPage () {
		return "view-status";
	}
	
	
	
}
