package com.jwxtssm.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jwxtssm.common.SpecialValues;
import com.jwxtssm.common.Utils;
import com.jwxtssm.dto.Result;
import com.jwxtssm.dto.UserInfoExecution;
import com.jwxtssm.dto.UserLoginExecution;
import com.jwxtssm.exception.CustomException;
import com.jwxtssm.service.IUserService;
import com.jwxtssm.service.impl.DefaultService;
import com.jwxtssm.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class UserController {
	@Autowired
	IUserService userService;
	@Autowired
	DefaultService defaultService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() {
		return "WEB-INF/html/login.html";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public JSON postLogin(String userId, String password, HttpSession session, HttpServletResponse
			httpServletResponse) {
		Utils.clearCookie(httpServletResponse, "set");
		Map<String, Object> resultMap = new TreeMap<>();
		if (userId == null || password == null) {
			resultMap.put("state", "fail");
			resultMap.put("message", "用户名和密码不能为空!");
			return new JSONObject(resultMap);
		} else {
			try {
				Result<UserLoginExecution> result = userService.login(userId, password);
				if (result.isSuccess()) {
					session.setAttribute(SpecialValues.USER_ID, result.getData().getBasicId());
					session.setAttribute(SpecialValues.AUTH_CODES, result.getData().getAuthCodes());
					session.setAttribute(SpecialValues.ROLES, result.getData().getRoles());
					resultMap.put("state", "success");
					Utils.clearCookie(httpServletResponse, "headImg");
					Utils.setSessionAttribute(session, "headImg", defaultService.getHeadImgByBasicId(result.getData()
							.getBasicId()));
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
	public String getLogout(HttpSession session, HttpServletResponse httpServletResponse) {
		Utils.clearCookie(httpServletResponse, "set");
		Utils.clearCookie(httpServletResponse, "headImg");
		session.invalidate();
		return "redirect:/home";
	}

	@RequestMapping(value = "/personalPage", method = RequestMethod.GET)
	public String getPersonalPage() {
		return "WEB-INF/html/personalPage.html";
	}

	@RequestMapping(value = "/getPersonalInfo", method = RequestMethod.POST)
	@ResponseBody
	public JSON postPersonalInfo(HttpSession session) throws CustomException {
		if (session.getAttribute(SpecialValues.USER_ID) == null) {
			throw new CustomException("请先登陆!");
		}
		Map<String, Object> resultMap = new TreeMap<>();
		UserInfoExecution userInfoExecution = userService.getUserInfo((Integer) session.getAttribute(SpecialValues
				.USER_ID));
		resultMap.put("viceId", userInfoExecution.getViceId());
		resultMap.put("name", userInfoExecution.getName());
		resultMap.put("sex", userInfoExecution.getSex());
		resultMap.put("height", userInfoExecution.getHeight());
		resultMap.put("weight", userInfoExecution.getWeight());
		resultMap.put("birthInfo", userInfoExecution.getBirthInfo());
		resultMap.put("homeAddress", userInfoExecution.getHomeAddress());
		resultMap.put("formalId", userInfoExecution.getFormalId());
		resultMap.put("rewardInfo", userInfoExecution.getRewardInfo());
		resultMap.put("punishmentInfo", userInfoExecution.getPunishmentInfo());
		resultMap.put("infoTransparency", userInfoExecution.getInfoTransparency());
		//		resultMap.put("types", userInfoExecution.getTypes());
		resultMap.put("infoes", userInfoExecution.getInfoes());

		resultMap.put("state", "success");
		return new JSONObject(resultMap);
	}

	@RequestMapping(value = "/updateBasicInfo", method = RequestMethod.POST)
	public String updateBasicInfo(HttpSession session, @RequestParam("user-name-input") String name, @RequestParam
			("user-password-input") String password, @RequestParam("user-sex-radios") String sex, @RequestParam
			("user-height-input") String height, @RequestParam("user-weight-input") String weight, @RequestParam
			("user-birth-input") String birth, @RequestParam("user-address-input") String address, @RequestParam
			("user-formal-id-input") String formalId, @RequestParam("user-select-info-transparency") String
			infoTransparency) throws CustomException, UnsupportedEncodingException {
		if (session.getAttribute(SpecialValues.USER_ID) == null) {
			throw new CustomException("请先登陆!");
		}
		userService.updateBasicInfo((Integer) session.getAttribute(SpecialValues.USER_ID), name, password, sex,
				height, weight, birth, address, formalId, infoTransparency);

		return "WEB-INF/html/personalPage.html";
	}

	@RequestMapping(value = "/updateAddressInfo", method = RequestMethod.POST)
	public String updateAddressInfo(HttpSession session, @RequestParam("user-address-text-input") String addressInfoes) throws CustomException {
		if (session.getAttribute(SpecialValues.USER_ID) == null) {
			throw new CustomException("请先登陆!");
		}
		userService.updateAddressInfo((Integer) session.getAttribute(SpecialValues.USER_ID), addressInfoes);

		return "WEB-INF/html/personalPage.html";
	}
}
