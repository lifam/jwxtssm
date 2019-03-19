package com.jwxtssm.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jwxtssm.dto.MajorQueryExecution;
import com.jwxtssm.service.IMajorService;
import com.jwxtssm.service.impl.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class MajorController {
	@Autowired
	IMajorService majorService;

	@RequestMapping(value = "/major", method = RequestMethod.GET)
	public String getQueryMajor() {
		return "WEB-INF/html/major.html";
	}

	@RequestMapping(value = "/major", method = RequestMethod.POST)
	@ResponseBody
	public JSON postQueryMajor(HttpSession session) {
		Map<String, Object> resultMap = new TreeMap<>();
		MajorQueryExecution majorQueryExecution = majorService.queryAll();
		resultMap.put("majorNames", majorQueryExecution.getMajorNames());
		resultMap.put("majorIds", majorQueryExecution.getMajorIds());
		//		if (session.getAttribute(SpecialValues.USER_ID) == null) {
		//			resultMap.put("state", "logout");
		//
		//		} else {
		//			resultMap.put("state", "login");
		//		}
		return new JSONObject(resultMap);
	}
}
