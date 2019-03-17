package com.jwxtssm.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jwxtssm.common.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class MessageController {
	@RequestMapping(value = "/getMessage", method = RequestMethod.POST)
	@ResponseBody
	public JSON postMessage(HttpSession session) {
		Map<String, Object> resultMap = new TreeMap<>();
		Object state = session.getAttribute("state");
		Object message = session.getAttribute("message");
		if (state == null) resultMap.put("state", "null");
		else {
			resultMap.put("state", state);
			Utils.clearSessionAttribute(session,"state");
		}
		if (message == null) resultMap.put("message", "null");
		else {
			resultMap.put("message", message);
			Utils.clearSessionAttribute(session, "message");
		}
		return new JSONObject(resultMap);
	}

	@RequestMapping(value = "/getMessage", method = RequestMethod.GET)
	public String getMessage() {
		return "WEB-INF/html/messagePage.html";
	}
}
