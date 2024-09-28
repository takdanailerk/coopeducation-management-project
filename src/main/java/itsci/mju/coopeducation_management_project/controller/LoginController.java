package itsci.mju.coopeducation_management_project.controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import itsci.mju.coopeducation_management_project.model.Staff;
import itsci.mju.coopeducation_management_project.repository.StaffRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	
	@Autowired
	private StaffRepository staffRepository;
	
	
	@GetMapping("/login")
	public String goToLonginPage () {
		return "login";
	}
	
	
//	@PostMapping("/login")
//    public String login(@RequestParam("username") String username,
//                        @RequestParam("password") String password,
//                        HttpSession session) {
//        // ตรวจสอบข้อมูล username และ password จากฐานข้อมูล
//        Staff staff = staffRepository.findByUsernameAndPassword(username, password);
//        if (staff != null) {
//            // เก็บข้อมูลลงใน Session
//            session.setAttribute("loggedInUser", staff);
//            session.setAttribute("role", staff.getRole());
//            return "redirect:/home"; // ถ้าล็อกอินสำเร็จ redirect ไปที่หน้า home
//        } else {
//            // ถ้าล็อกอินไม่สำเร็จ redirect กลับไปที่หน้า login พร้อม error message
//            return "redirect:/login?error=true";
//        }
//    }
	
	
	 @GetMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        return "redirect:/login";
	    }
	
//	 @GetMapping("/home")
//	    public String home(HttpSession session) {
//	        // ตรวจสอบว่าผู้ใช้ล็อกอินแล้วหรือยัง
//	        if (session.getAttribute("loggedInUser") == null) {
//	            return "redirect:/login"; // ถ้าไม่ได้ล็อกอิน redirect ไปที่หน้า login
//	        }
//	        return "home"; // ถ้าล็อกอินแล้วแสดงหน้า home.jsp
//	    }
	
	 @GetMapping("/home")
	    public String home() {
	       
	        return "home"; // ถ้าล็อกอินแล้วแสดงหน้า home.jsp
	    }
}
