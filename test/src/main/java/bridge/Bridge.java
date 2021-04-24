package bridge;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import student.StudentDetails;

@Controller
public class Bridge {

	@RequestMapping("/")
	public String welcome() {
		System.out.println("Welcome to the controller");
		return "Welcome";
	}
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "studentForm";
	}
	
	@RequestMapping("/validateForm")
	public String validateForm() {
		return "validateForm";
	}
	
	@RequestMapping("/validateFormVersion2")
	public String validateFormVersion2(HttpServletRequest request , Model model) {
		String theAlteredString = " This is a first student and his name is : " 
			+ request.getParameter("studentName");
		model.addAttribute("theStudentInfo", theAlteredString);
		return "validateForm";
	}
	
	@RequestMapping("/validateFormVersion3")
	public String validateFormVersion3(@RequestParam("studentName") String nameOfTheStudent , Model model) {
		String theAlteredString =  
			 nameOfTheStudent.toUpperCase() ;
		model.addAttribute("theStudentInfo", theAlteredString);
		return "validateForm";
	}
	
	@RequestMapping("/validateFormVersion4")
	public String validateFormVersion4(@ModelAttribute("studentName") StudentDetails nameOfTheStudent , Model model) {
		String theAlteredString =  
		" My first name is : "	+ nameOfTheStudent.getFirstName();
		model.addAttribute("theStudentInfo", theAlteredString);
		return "validateForm";
	}
	
	@RequestMapping("/studentModel")
	public String showStudentModel(Model model) {
		model.addAttribute("studentName", new StudentDetails());
		return "studentModel";
	}
	
	@RequestMapping("/StudentValidator")
	public String StudentValidator(Model model) {
		model.addAttribute("studentName", new StudentDetails());
		return "StudentValidator";
	}
	
	@RequestMapping("/checkForm")
	public String validateForm(@Valid 
			@ModelAttribute("studentName") 
			StudentDetails nameOfTheStudent 
			, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Got an error");
			return "StudentValidator";
		}else {
			return "modelForm";
		}
	}
}
