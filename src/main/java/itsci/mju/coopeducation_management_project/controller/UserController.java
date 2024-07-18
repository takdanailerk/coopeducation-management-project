package itsci.mju.coopeducation_management_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import itsci.mju.coopeducation_management_project.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String goToUserPage (Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "home";
	}
	
}
