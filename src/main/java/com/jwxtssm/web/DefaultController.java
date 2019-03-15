package com.jwxtssm.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jwxtssm.common.SpecialValues;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class DefaultController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage() {
		return "html/home.html";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	@ResponseBody
	public JSON getHomePage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Map<String, Object> resultMap = new TreeMap<>();
//		Cookie cookie = new Cookie("set", "true");
//		cookie.setPath("/");
//		httpServletResponse.addCookie(cookie);

		Object basic_id = httpServletRequest.getSession().getAttribute(SpecialValues.USER_ID);
		if (httpServletRequest.getSession().getAttribute(SpecialValues.USER_ID) == null) {
			resultMap.put("state", "fail");
//			cookie = new Cookie("state", "fail");
//			cookie.setPath("/");
//			httpServletResponse.addCookie(cookie);
		} else {
			HttpSession session = httpServletRequest.getSession();
			resultMap.put("state", "success");
			resultMap.put("authCodes", session.getAttribute(SpecialValues.AUTH_CODES));
//			cookie = new Cookie("state", "success");
//			cookie.setPath("/");
//			httpServletResponse.addCookie(cookie);
//			cookie = new Cookie("authCodes", "success");
//			cookie.setPath("/");
//			httpServletResponse.addCookie(cookie);
		}

		return new JSONObject(resultMap);
	}
}
