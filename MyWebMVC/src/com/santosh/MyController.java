package com.santosh;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/")
	public String showPage() {
		return "show-page";
	}
	
	@RequestMapping("/ProcessForm")
	public String viewPage() {
		return "veiw-page";
	}
	
	//New controller method to read the form data
	@RequestMapping("/ProcessFromVersionTwo")
	public String shoutDude(HttpServletRequest request, Model model) {
		
		String str = request.getParameter("studentName");
		
		str = str.toUpperCase();
		
		String msg = "Yo!";
		
		model.addAttribute("message", str);
		model.addAttribute("Init", msg);		
		return "showpage";
	}
}
