package com.ghassan.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//The controller class
@Controller
public class HomeController {
 
	//The controller method
	@RequestMapping("/")
	public String showPage() {
		//return the page name. it will turn to /WEB-INF/view/main-menu.jsp
		return "home-page";
	}
}
