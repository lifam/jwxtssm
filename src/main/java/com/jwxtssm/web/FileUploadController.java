package com.jwxtssm.web;

import com.jwxtssm.common.SpecialValues;
import com.jwxtssm.common.Utils;
import com.jwxtssm.dto.DocsQueryExecution;
import com.jwxtssm.exception.CustomException;
import com.jwxtssm.service.impl.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
public class FileUploadController {
	@Autowired
	FileUploadService fileUploadService;

	@RequestMapping(value = "/fileUpload", method = RequestMethod.GET)
	public String getFileUpload() {
		return "WEB-INF/html/fileUpload.html";
	}

	@RequestMapping(value = "/updateHeadImg", method = RequestMethod.POST)
	public String updateHeadImg(@RequestParam("file-single-input") MultipartFile multipartFile, HttpSession session,
								HttpServletResponse httpServletResponse) throws CustomException {
		if (session.getAttribute(SpecialValues.USER_ID) == null) {
			throw new CustomException("请先登陆!");
		}
		if (fileUploadService.updateHeadImg(session, multipartFile, (Integer) session.getAttribute
				(SpecialValues.USER_ID))) {
			Utils.setSessionAttribute(session, "state", "success");
			Utils.setSessionAttribute(session, "message", "修改头像成功!");
			Utils.clearCookie(httpServletResponse, "set");
			Utils.clearCookie(httpServletResponse, "headImg");
		} else {
			throw new CustomException("修改头像时遇到未知错误,请联系管理员!");
		}
		return "redirect:/getMessage";
	}

	@RequestMapping(value = "/deleteHeadImg", method = RequestMethod.POST)
	public String deleteHeadImg(HttpSession session, HttpServletResponse httpServletResponse) throws CustomException {
		if (session.getAttribute(SpecialValues.USER_ID) == null) {
			throw new CustomException("请先登陆!");
		}
		if (fileUploadService.deleteHeadImg(session, (Integer) session.getAttribute(SpecialValues.USER_ID))) {
			Utils.setSessionAttribute(session, "state", "success");
			Utils.setSessionAttribute(session, "message", "删除头像成功!");
			Utils.clearCookie(httpServletResponse, "set");
			Utils.clearCookie(httpServletResponse, "headImg");
		} else {
			throw new CustomException("删除头像时遇到未知错误,请联系管理员!");
		}
		return "redirect:/getMessage";
	}

	@RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
	public String uploadFiles(@RequestParam("file-multiple-input") MultipartFile[] multipartFiles, HttpSession
			session) throws CustomException {
		if (session.getAttribute(SpecialValues.USER_ID) == null) {
			throw new CustomException("请先登陆!");
		}
		int uploadCount = fileUploadService.uploadFile(session, multipartFiles, (Integer) session.getAttribute
				(SpecialValues.USER_ID));
		Utils.setSessionAttribute(session, "state", "success");
		Utils.setSessionAttribute(session, "message", "上传文件成功!共上传了 " + uploadCount + " 个文件!");
		return "redirect:/getMessage";
	}

	@RequestMapping(value = "/getDocManagement", method = RequestMethod.GET)
	public ModelAndView getDocManagement(HttpSession session) throws CustomException {
		if (session.getAttribute(SpecialValues.USER_ID) == null) {
			throw new CustomException("请先登陆!");
		}
		ModelAndView mov = new ModelAndView();
		DocsQueryExecution docsQueryExecution = fileUploadService.queryDocs(session, (Integer) session.getAttribute
				(SpecialValues.USER_ID));

		mov.addObject("docNames", docsQueryExecution.getDocNames());
		mov.addObject("docIds", docsQueryExecution.getDocIds());
		mov.addObject("publishDates", docsQueryExecution.getPublishDates());
		mov.addObject("docSizes", docsQueryExecution.getDocSizes());

		mov.setViewName("WEB-INF/jsp/docManagement.jsp");
		return mov;
	}

	@RequestMapping(value = "/downloadUploadFiles", method = RequestMethod.GET)
	public String downloadUploadFiles(HttpSession session, int docId) throws CustomException {
		if (session.getAttribute(SpecialValues.USER_ID) == null) {
			throw new CustomException("请先登陆!");
		}
		String docName = fileUploadService.downloadDoc((Integer) session.getAttribute(SpecialValues.USER_ID), docId);
		return SpecialValues.DOCS_BASE_PATH + File.separator + docName;
	}

	@RequestMapping(value = "/deleteUploadFiles", method = RequestMethod.GET)
	public String deleteUploadFiles(HttpSession session, int docId) throws CustomException {
		if (session.getAttribute(SpecialValues.USER_ID) == null) {
			throw new CustomException("请先登陆!");
		}

		if (fileUploadService.deleteFile(session, (Integer) session.getAttribute(SpecialValues.USER_ID), docId)) {
			Utils.setSessionAttribute(session, "state", "success");
			Utils.setSessionAttribute(session, "message", "删除文件成功!");
		} else {
			throw new CustomException("删除文件时遇到未知错误,请联系管理员!");
		}
		return "redirect:/getMessage";
	}
}
