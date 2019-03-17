package com.jwxtssm.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jwxtssm.common.SpecialValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class DefaultController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage() {
		return "WEB-INF/html/home.html";
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	@ResponseBody
	public JSON getHomePage(HttpSession session) {
		Map<String, Object> resultMap = new TreeMap<>();

		Object basic_id = session.getAttribute(SpecialValues.USER_ID);
		if (basic_id == null) {
			resultMap.put("state", "fail");
		} else {
			resultMap.put("state", "success");
			resultMap.put("authCodes", session.getAttribute(SpecialValues.AUTH_CODES));
		}

		return new JSONObject(resultMap);
	}

	@RequestMapping(value = "/getHeadImg", method = RequestMethod.GET)
	public String getHeadImg(HttpSession session) {
		logger.debug("尝试获取头像地址");
		String headImgPath = (String) session.getAttribute("headImg");
		logger.debug("获取到的头像地址为：" + ((headImgPath == null) ? "images/defaultHeadImg.jpg" : headImgPath));
		return (headImgPath == null) ? "images/defaultHeadImg.jpg" : headImgPath;
	}
}
