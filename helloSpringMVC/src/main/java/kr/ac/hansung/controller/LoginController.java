package kr.ac.hansung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping("/login") // /login 리퀘스트 날아올때 showLogin 실행
	public String showLogin( @RequestParam(value="error", required=false) String error,
			@RequestParam(value="logout", required=false) String logout,Model model) {
		if(error !=null) {
			model.addAttribute("errorMsg", "Invalid username and password");
		}
		
		if(logout!=null) {
			model.addAttribute("logoutMsg", "You have been logout successfully!");
		}
		return "login";
	}

}


		
