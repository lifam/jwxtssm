package com.jwxtssm.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jwxtssm.common.SpecialValues;
import com.jwxtssm.common.Utils;
import com.jwxtssm.dto.Result;
import com.jwxtssm.dto.UserLoginExecution;
import com.jwxtssm.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//		Utils.clearCookie(httpServletResponse);
//		httpServletRequest.getSession().invalidate();
		return "html/login.html";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public JSON postLogin(String userId, String password, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Utils.clearCookie(httpServletResponse);
		Map<String, Object> resultMap = new TreeMap<>();
		if (userId == null || password == null) {
			resultMap.put("state", "fail");
			resultMap.put("message", "用户名和密码不能为空!");
			return new JSONObject(resultMap);
		} else {
			try {
				Result<UserLoginExecution> result = userService.login(userId, password);
				if (result.isSuccess()) {
					HttpSession session = httpServletRequest.getSession();
					session.setAttribute(SpecialValues.USER_ID, result.getData().getBasicId());
					session.setAttribute(SpecialValues.AUTH_CODES, result.getData().getAuthCodes());
					session.setAttribute(SpecialValues.ROLES, result.getData().getRoles());
					resultMap.put("state", "success");
				} else {
					resultMap.put("state", "fail");
					resultMap.put("message", result.getError());
				}
				return new JSONObject(resultMap);
			} catch (NumberFormatException cause) {
				resultMap.put("state", "fail");
				resultMap.put("message", "用户id必须为数字!");
				return new JSONObject(resultMap);
			} catch (Exception cause) {
				resultMap.put("state", "fail");
				resultMap.put("message", "遇到未知错误,请联系管理员!");
				cause.printStackTrace();
				return new JSONObject(resultMap);
			}
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String getLogout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		Utils.clearCookie(httpServletResponse);
		httpServletRequest.getSession().invalidate();
		return "html/home.html";
	}
}
