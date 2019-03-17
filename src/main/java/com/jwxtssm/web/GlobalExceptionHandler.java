package com.jwxtssm.web;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.jwxtssm.common.Utils;
import com.jwxtssm.exception.CustomException;
import com.jwxtssm.exception.UnknownException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.TreeMap;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CustomException.class)
	public String handleCustomException(HttpSession session, CustomException cause) {
		cause.printStackTrace();
		Utils.setSessionAttribute(session, "state", "fail");
		Utils.setSessionAttribute(session, "message", cause.getMessage());
		return "redirect:/getMessage";
	}

	@ExceptionHandler(UnknownException.class)
	public String handleUnknownException(HttpSession session, UnknownException cause) {
		cause.printStackTrace();
		Utils.setSessionAttribute(session, "state", "fail");
		Utils.setSessionAttribute(session, "message", "系统遇到未知错误,请联系管理员!");
		return "redirect:/getMessage";
	}

	@ExceptionHandler(Exception.class)
	public String handleAllException(HttpSession session, Exception cause) {
		cause.printStackTrace();
		Utils.setSessionAttribute(session, "state", "fail");
		Utils.setSessionAttribute(session, "message", "运行时错误,请联系管理员!");
		return "redirect:/getMessage";
	}
}
