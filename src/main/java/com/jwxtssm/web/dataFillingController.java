package com.jwxtssm.web;

import com.jwxtssm.service.DataGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class dataFillingController {
	@Autowired
	DataGenerate dataGenerate;

	@RequestMapping(value = "/fillBasicInfo.html")
	public ModelAndView fillBasicInfo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		return getModelAndView(dataGenerate.generateBasicInfo());
	}

	@RequestMapping(value = "/fillAuthInfo.html")
	public ModelAndView fillAuthInfo(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		return getModelAndView(dataGenerate.generateAuthInfo());
	}

	@RequestMapping(value = "/fillCollege.html")
	public ModelAndView fillCollege(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		return getModelAndView(dataGenerate.generateCollege());
	}

	@RequestMapping(value = "/fillMajor.html")
	public ModelAndView fillMajor(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		return getModelAndView(dataGenerate.generateMajor());
	}

	@RequestMapping(value = "/fillOrg.html")
	public ModelAndView fillOrg(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		return getModelAndView(dataGenerate.generateOrg());
	}

	@RequestMapping(value = "/fillRole.html")
	public ModelAndView fillRole(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		return getModelAndView(dataGenerate.generateRole());
	}

	private ModelAndView getModelAndView(int i) throws Exception {
		ModelAndView mav = new ModelAndView();

		int count = i;

		mav.addObject("msg", "成功插入了 " + count + " 条数据.");
		mav.setViewName("test/test");
		return mav;
	}
}
