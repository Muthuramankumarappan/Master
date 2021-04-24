package bridge;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import student.StudentDetails;

@Controller
@RequestMapping("valid")
public class FormValidation {

	
	@RequestMapping("/validateForm")
	public String validateForm(@Valid 
			@ModelAttribute("studentName") 
			StudentDetails nameOfTheStudent 
			, BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Got an error");
			return "StudentValidator";
		}else {
			return "validateForm";
		}
	}
}
