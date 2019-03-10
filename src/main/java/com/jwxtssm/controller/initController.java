package com.jwxtssm.controller;

import com.jwxtssm.service.DatabaseInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class initController implements org.springframework.web.servlet.mvc.Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		ModelAndView mav = new ModelAndView();

		String result = databaseInit.init();

		mav.addObject("msg", result);
		mav.setViewName("init");
		return mav;
	}
}
