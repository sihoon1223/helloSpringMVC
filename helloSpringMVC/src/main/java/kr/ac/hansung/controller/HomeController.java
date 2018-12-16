package kr.ac.hansung.controller;


import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller // @Component+alpha(컨트롤러역할)
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome(Locale locale, Model model) {

		return "home";
	}

}

