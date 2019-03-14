package com.jwxtssm.web;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.jwxtssm.exception.CustomException;
import com.jwxtssm.exception.UnknownException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.TreeMap;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CustomException.class)
	public ModelAndView handleCustomException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, CustomException cause) {
		ModelAndView mov = new ModelAndView();

		boolean isAjaxRequest = false;
		if (!StringUtils.isBlank(httpServletRequest.getHeader("x-requested-with")) && httpServletRequest.getHeader("x-requested-with").equals("XMLHttpRequest")) isAjaxRequest = true;

		if (isAjaxRequest) {
			FastJsonJsonView view = new FastJsonJsonView();
			Map<String, Object> map = new TreeMap<>();
			map.put("code", 500);
			map.put("message", cause.getMessage());
			view.setAttributesMap(map);
			mov.setView(view);
		} else {
			mov.addObject("description", "服务器内部已知错误!");
			mov.addObject("message", cause.getMessage());
			mov.setViewName("error");
		}

		return mov;
	}

	@ExceptionHandler(UnknownException.class)
	public ModelAndView handleUnknownException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, UnknownException cause) {
		ModelAndView mov = new ModelAndView();

		boolean isAjaxRequest = false;
		if (!StringUtils.isBlank(httpServletRequest.getHeader("x-requested-with")) && httpServletRequest.getHeader("x-requested-with").equals("XMLHttpRequest")) isAjaxRequest = true;

		if (isAjaxRequest) {
			FastJsonJsonView view = new FastJsonJsonView();
			Map<String, Object> map = new TreeMap<>();
			map.put("code", 501);
			map.put("message", cause.getMessage());
			view.setAttributesMap(map);
			mov.setView(view);
		} else {
			mov.addObject("description", "服务器内部未知错误!");
			mov.addObject("message", cause.getMessage());
			mov.setViewName("error");
		}

		return mov;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Exception cause) {
		ModelAndView mov = new ModelAndView();

		boolean isAjaxRequest = false;
		if (!StringUtils.isBlank(httpServletRequest.getHeader("x-requested-with")) && httpServletRequest.getHeader("x-requested-with").equals("XMLHttpRequest")) isAjaxRequest = true;

		if (isAjaxRequest) {
			FastJsonJsonView view = new FastJsonJsonView();
			Map<String, Object> map = new TreeMap<>();
			map.put("code", 502);
			map.put("message", cause.getMessage());
			view.setAttributesMap(map);
			mov.setView(view);
		} else {
			mov.addObject("description", "服务器内部错误!");
			mov.addObject("message", cause.getMessage());
			mov.setViewName("error");
		}

		return mov;
	}
}
