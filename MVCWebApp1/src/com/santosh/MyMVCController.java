package com.santosh;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyMVCController {

	@RequestMapping("/")
	public String getIndexPage() {
		return "index";
	}

	@RequestMapping("/submitAction")
	public String getFirstForm(@RequestParam("studentName") String studentName,  Model model) {
	//public String getFirstForm(HttpServletRequest request, Model model) {

		//String upperCaseName = request.getParameter("studentName");
		String upperCaseName = studentName;
		upperCaseName = upperCaseName.toUpperCase();
		model.addAttribute("msg", upperCaseName);
		model.addAttribute("welcome", "Hellow.......");
		return "firstForm";
	}

}
