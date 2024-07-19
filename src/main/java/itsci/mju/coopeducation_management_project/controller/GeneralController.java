package itsci.mju.coopeducation_management_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

	@GetMapping("/")
	public String goToHomePage () {
		return "home";
	}
	
}
