package itsci.mju.coopeducation_management_project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import itsci.mju.coopeducation_management_project.model.Major;
import itsci.mju.coopeducation_management_project.service.MajorService;

@Controller
@RequestMapping("/majors")
public class MajorController {

	@Autowired
	private MajorService majorService;
	
	@GetMapping("/list-majors-page")
	public String goToListMajorsPage (Model model) {
		model.addAttribute("majors", majorService.getAllMajors());
		return "list-major";
	}
	
	@GetMapping("/add-major-page")
	public String goToAddMajorPage (Model model) {
		model.addAttribute("majors", majorService.getAllMajors());
		return "add-major";
	}
	
	@GetMapping("/update-major-page/{majorId}")
	public String goToUpdateMajorPage (Model model, @PathVariable String majorId) {
		model.addAttribute("major", majorService.getMajorById(Long.valueOf(majorId)));
		return "update-major";
	}
	
	@PostMapping("/add")
	public String addMajor (@RequestParam Map<String, String> requestBody) {
		majorService.addMajor(requestBody);
		return "redirect:/majors/list-majors-page";
	}
	
	@PostMapping("/update/{majorId}")
	public String updateMajor (Major updatedMajor, @PathVariable String majorId) {
		majorService.updateMajor(updatedMajor);
		return "redirect:/majors/list-majors-page";
	}
	
	@GetMapping("/delete/{majorId}")
	public String deleteMajor (@PathVariable String majorId) {
		majorService.deleteMajor(Long.valueOf(majorId));
		return "redirect:/majors/list-majors-page";
	}
	
}
