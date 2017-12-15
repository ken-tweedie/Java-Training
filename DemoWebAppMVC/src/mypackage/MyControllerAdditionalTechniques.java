package mypackage;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/myfolder")
@SessionAttributes(value={"myCounter1", "myCounter2"})
public class MyControllerAdditionalTechniques {

	@RequestMapping("/page1a.htm")
	public ModelAndView show1a(HttpServletRequest request) {
		
		ModelAndView result = new ModelAndView();
		result.addObject("greeting", "Hello, you requested /DemoWebAppMvc/additional/page1a.htm");
		result.setViewName("displayGreeting");
		return result;
	}


	@RequestMapping("/page1b.htm")
	public ModelAndView show1b(HttpServletRequest request) {
		
		ModelAndView result = new ModelAndView();
		result.addObject("greeting", "Hello, you requested " + request.getRequestURI());
		result.setViewName("displayGreeting");
		return result;
	}

	@RequestMapping("/page2.htm")
	public ModelAndView showName(@RequestParam("firstName")String firstName,
			                     @RequestParam(value="middleName", required=false)String middleName,
			                     @RequestParam("lastName")String lastName) {
		
		ModelAndView result = new ModelAndView();
		if (middleName == null) 
			result.addObject("fullName", firstName + " " + lastName);
		else
			result.addObject("fullName", firstName + " " + middleName + " " + lastName);

		result.setViewName("displayFullName");
		return result;
	}


	@RequestMapping(value="/page3.htm", params="country=cy")
	public ModelAndView showNameWelsh(@RequestParam("firstName")String firstName,
			                          @RequestParam(value="middleName", required=false)String middleName,
			                          @RequestParam("lastName")String lastName) {
		
		ModelAndView result = new ModelAndView();
		if (middleName == null) 
			result.addObject("fullName", firstName + " " + lastName + ", sut rydych chi?");
		else
			result.addObject("fullName", firstName + " " + middleName + " " + lastName + ", sut rydych chi?");
	
		result.setViewName("displayFullName");
		return result;
	}
	
	
	@RequestMapping(value="/page3.htm", params="country=fr")
	public ModelAndView showNameFrench(@RequestParam("firstName")String firstName,
			                           @RequestParam(value="middleName", required=false)String middleName,
			                           @RequestParam("lastName")String lastName) {
		
		ModelAndView result = new ModelAndView();
		if (middleName == null) 
			result.addObject("fullName", firstName + " " + lastName + ", ca va?");
		else
			result.addObject("fullName", firstName + " " + middleName + " " + lastName + ", ca va?");
	
		result.setViewName("displayFullName");
		return result;
	}
	
	
	@RequestMapping(value="/page3.htm", params="!country")
	public ModelAndView showNameDefault(@RequestParam("firstName")String firstName,
			                            @RequestParam(value="middleName", required=false)String middleName,
			                            @RequestParam("lastName")String lastName) {
		
		ModelAndView result = new ModelAndView();
		if (middleName == null) 
			result.addObject("fullName", firstName + " " + lastName + ", how are you?");
		else
			result.addObject("fullName", firstName + " " + middleName + " " + lastName + ", how are you?");
	
		result.setViewName("displayFullName");
		return result;
	}

	
	@RequestMapping(value="/page4.htm")
	public String incrementMyCounters(ModelMap model) {
		
		Integer myCounter1 = (Integer)model.get("myCounter1");
		if (myCounter1 == null) {
			model.addAttribute("myCounter1", 1);
		}
		else {
			model.addAttribute("myCounter1", myCounter1.intValue() + 1);
		}
		
		Integer myCounter2 = (Integer)model.get("myCounter2");
		if (myCounter2 == null) {
			model.addAttribute("myCounter2", 2);
		}
		else {
			model.addAttribute("myCounter2", myCounter2.intValue() + 2);
		}
		
		return "displayMyCounters";
	}
	
	
	@ModelAttribute("players")
	public Collection<String> populatePlayers() {
		
		Collection<String> players = new ArrayList<String>();
		players.add("Dorus de Vries");
		players.add("Ashley Williams");
		players.add("Neil Taylor");
		return players;
	}
		
	@Autowired
	private MyService service;
	
	@RequestMapping("/page5a.htm")
	public ModelAndView showTimestamp() {
		
		ModelAndView result = new ModelAndView();
		result.addObject("timestamp", service.getTimestamp());
		result.setViewName("displayTimestamp");
		return result;
	}

	@RequestMapping("/page5b.htm")
	public ModelAndView showMessage() {
		
		ModelAndView result = new ModelAndView();
		result.addObject("message", service.getMessage());
		result.setViewName("displayMessage");
		return result;
	}
}
