package com.jwxtssm.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jwxtssm.common.SpecialValues;
import com.jwxtssm.dto.CollegeQueryExecution;
import com.jwxtssm.service.impl.CollegeService;
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
public class CollegeController {
	@Autowired
	CollegeService collegeService;

	@RequestMapping(value = "/college", method = RequestMethod.POST)
	@ResponseBody
	public JSON postQueryCollege(HttpSession session) {
		Map<String, Object> resultMap = new TreeMap<>();
		CollegeQueryExecution collegeQueryExecution = collegeService.queryAll();
		resultMap.put("collegeNames", collegeQueryExecution.getCollegeNames());
		resultMap.put("collegeIds", collegeQueryExecution.getCollegeIds());
//		if (session.getAttribute(SpecialValues.USER_ID) == null) {
//			resultMap.put("state", "logout");
//
//		} else {
//			resultMap.put("state", "login");
//		}
		return new JSONObject(resultMap);
	}
}
