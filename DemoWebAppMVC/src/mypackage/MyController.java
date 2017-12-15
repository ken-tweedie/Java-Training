package mypackage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

	@RequestMapping("/page.htm")
	public ModelAndView show(HttpServletRequest request) {
		
		String language = request.getParameter("language");
		
		ModelAndView result = new ModelAndView();
		if (language != null && language.equals("French"))
			result.addObject("greeting", "Bonjour!");
		else
			result.addObject("greeting", "Hello!");
		
		//result.setViewName("/WEB-INF/views/displayGreeting.jsp");
		result.setViewName("displayGreeting");
		return result;
	}
}
