package com.jwxtssm.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage() {
		return "html/home.html";
	}

	//	@RequestMapping(value = "/home", method = RequestMethod.POST)
	//	public String getHomePage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
	//				Object basic_id = httpServletRequest.getSession().getAttribute(SpecialValues.USER_ID);
	//				if (httpServletRequest.getSession().getAttribute(SpecialValues.USER_ID) == null) {
	//
	//				} else {
	//
	//				}
	//	}
}
