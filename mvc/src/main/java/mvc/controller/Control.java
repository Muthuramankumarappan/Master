package mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Control {

	@RequestMapping("/")
	public String getHomePage() {
		return "home";
	}
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "showForm";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "processForm";
	}
	
	@RequestMapping("/processFormVersion")
	public String processFormVersion(HttpServletRequest req, Model modl) {
	String returnValue = "You are great" + 
	req.getParameter("studentName")
		.toUpperCase();
		modl.addAttribute("msg", returnValue);
		return "processForm";
	}
	
	@RequestMapping("/processFormVersion2")
	public String processFormVersion2(@RequestParam("studentName") String theName
			, Model modl) {
	String returnValue = "You are My friend " + 
			theName
		.toUpperCase();
		modl.addAttribute("msg", returnValue);
		return "processForm";
	}
	
	@RequestMapping("/processFormVersion3")
	public String processFormVersion3(
			@Valid
			@RequestParam("studentName") String theName
			, Model modl,
			BindingResult result) {
	String returnValue = "You are My friend " + 
			theName
		.toUpperCase();
		modl.addAttribute("msg", returnValue);
		return "processForm";
	}
}
