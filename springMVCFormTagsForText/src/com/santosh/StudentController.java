package com.santosh;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;



@Controller
public class StudentController {
	
	
	@Value("#{countryOptions}") 
	private Map<String, String> countryOptions;
	
	@RequestMapping("/")
	public String showFrom(Model model) {
		
		Student theStudent = new Student();
		
		model.addAttribute("student", theStudent);
		model.addAttribute("theCountryOptions", countryOptions);
		return "show-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student tStudent) {
		return "student-confirmation";
	}
	
}
