package com.jwxtssm.controller;

import com.jwxtssm.service.DatabaseInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class initController {

	DatabaseInit databaseInit;

	@RequestMapping(value = "/init.html")
	public ModelAndView initRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		ModelAndView mav = new ModelAndView();

		String result = databaseInit.init();

		mav.addObject("msg", result);
		mav.setViewName("init");
		return mav;
	}
}
