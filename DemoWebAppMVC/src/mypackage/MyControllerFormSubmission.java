package mypackage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee.htm")
public class MyControllerFormSubmission {


	@RequestMapping(method = RequestMethod.GET)
	public String showEmployeeForm(@RequestParam(value="id", required=false, defaultValue="0") int id, ModelMap model) {
		model.addAttribute("employee", new Employee(id));
		return "employee";
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submitEmployee(@ModelAttribute("employee")Employee employee) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employeeSummary", employee);
		modelAndView.setViewName("employeeSummary");

		return modelAndView;
	}
}
