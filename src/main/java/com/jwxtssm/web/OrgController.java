package com.jwxtssm.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jwxtssm.dto.OrgQueryExecution;
import com.jwxtssm.service.IOrgService;
import com.jwxtssm.service.impl.OrgService;
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
public class OrgController {
	@Autowired
	IOrgService orgService;

	@RequestMapping(value = "/org", method = RequestMethod.GET)
	public String getQueryMajor() {
		return "WEB-INF/html/org.html";
	}

	@RequestMapping(value = "/org", method = RequestMethod.POST)
	@ResponseBody
	public JSON postQueryMajor(HttpSession session) {
		Map<String, Object> resultMap = new TreeMap<>();
		OrgQueryExecution orgQueryExecution = orgService.queryAll();
		resultMap.put("orgNames", orgQueryExecution.getOrgNames());
		resultMap.put("orgIds", orgQueryExecution.getOrgIds());
		//		if (session.getAttribute(SpecialValues.USER_ID) == null) {
		//			resultMap.put("state", "logout");
		//
		//		} else {
		//			resultMap.put("state", "login");
		//		}
		return new JSONObject(resultMap);
	}
}
