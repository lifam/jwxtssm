package com.jwxtssm.service.impl;

import com.jwxtssm.common.DefaultPojo;
import com.jwxtssm.common.DefaultValues;
import com.jwxtssm.common.SpecialValues;
import com.jwxtssm.common.Utils;
import com.jwxtssm.dao.BasicInfoDao;
import com.jwxtssm.dao.DocCenterDao;
import com.jwxtssm.dao.FileManager;
import com.jwxtssm.dto.DocsQueryExecution;
import com.jwxtssm.entity.BasicInfo;
import com.jwxtssm.entity.DocCenter;
import com.jwxtssm.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.sql.Date;

@Service
public class FileUploadService {
	@Autowired
	BasicInfoDao basicInfoDao;
	@Autowired
	DocCenterDao docCenterDao;

	@Transactional
	public boolean updateHeadImg(HttpSession session, MultipartFile multipartFile, int basicId) throws
			CustomException {
		BasicInfo basicInfo = basicInfoDao.queryById(basicId);
		if (basicInfo == null) {
			throw new CustomException("操作:修改头像,用户不存在!");
		}
		DocCenter docCenter = docCenterDao.queryById(basicInfo.getHeadImg());

		String basePath = session.getServletContext().getRealPath(SpecialValues.HEAD_IMG_BASE_PATH);
		basePath += File.separator;
		String newHeadImgFileName = Utils.constructFileName(basicId, multipartFile.getOriginalFilename());

		if (basicInfo.getHeadImg() != DefaultValues.HEAD_IMG) {
			//      头像不是默认头像,修改即可
			if (docCenter.getState() == SpecialValues.DOC_STATE_VALID && docCenter.getType() == SpecialValues
					.DOC_TYPE_HEAD_IMG) {
				FileManager.removeFile(session.getServletContext().getRealPath(SpecialValues.HEAD_IMG_BASE_PATH) + File.separator +
						docCenter.getDocAddress());
			}
			docCenter.setState(SpecialValues.DOC_STATE_VALID);
			docCenter.setDocAddress(newHeadImgFileName);
			docCenter.setType(SpecialValues.DOC_TYPE_HEAD_IMG);
			docCenter.setPublishDate(Utils.constructNewDate());
			docCenterDao.updateById(docCenter);
		} else {
			//          头像是默认头像,要先添加文件记录
			docCenter.setBasicId(basicId);
			docCenter.setState(SpecialValues.DOC_STATE_VALID);
			docCenter.setDocAddress(newHeadImgFileName);
			docCenter.setType(SpecialValues.DOC_TYPE_HEAD_IMG);
			docCenter.setPublishDate(Utils.constructNewDate());

			docCenterDao.addDocCenter(docCenter);
			basicInfo.setHeadImg(docCenter.getDocId());
			basicInfoDao.updateHeadImg(basicInfo);
		}

		FileManager.addFile(multipartFile, basePath + newHeadImgFileName);
		Utils.setSessionAttribute(session, "headImg", SpecialValues.HEAD_IMG_BASE_PATH + File.separator + newHeadImgFileName);
		return true;
	}

	@Transactional
	public boolean deleteHeadImg(HttpSession session, int basicId) throws CustomException {
		BasicInfo basicInfo = basicInfoDao.queryById(basicId);
		if (basicInfo == null) {
			throw new CustomException("操作:删除头像,用户不存在!");
		}
		if (basicInfo.getHeadImg() != DefaultValues.HEAD_IMG) {
			DocCenter docCenter = docCenterDao.queryById(basicInfo.getHeadImg());
			if (docCenter.getState() == SpecialValues.DOC_STATE_VALID && docCenter.getType() == SpecialValues
					.DOC_TYPE_HEAD_IMG) {
				FileManager.removeFile(session.getServletContext().getRealPath(SpecialValues.HEAD_IMG_BASE_PATH) + File.separator +
						docCenter.getDocAddress());
			}

			docCenterDao.deleteById(docCenter.getDocId());
			basicInfo.setHeadImg(DefaultValues.HEAD_IMG);
			basicInfoDao.updateHeadImg(basicInfo);
		}

		Utils.setSessionAttribute(session, "headImg", "images/defaultHeadImg.jpg");
		return true;
	}

	@Transactional
	public int uploadFile(HttpSession session, MultipartFile[] multipartFiles, int basicId) throws CustomException {
		BasicInfo basicInfo = basicInfoDao.queryById(basicId);
		if (basicInfo == null) {
			throw new CustomException("操作:上传文件,用户不存在!");
		}

		DocCenter docCenter = DefaultPojo.getDefaultDocCenter();
		docCenter.setBasicId(basicId);
		docCenter.setState(SpecialValues.DOC_STATE_VALID);
		docCenter.setType(SpecialValues.DOC_TYPE_OTHER);
		docCenter.setPublishDate(Utils.constructNewDate());

		String basePath = session.getServletContext().getRealPath(SpecialValues.DOCS_BASE_PATH);
		basePath += File.separator;
		int uploadCount = 0;
		for (int i = 0; i < multipartFiles.length; i++) {
			String filePath = Utils.constructFileName(basicId, multipartFiles[i].getOriginalFilename());
			if (FileManager.addFile(multipartFiles[i], basePath + filePath)) {
				docCenter.setDocAddress(filePath);
				docCenterDao.addDocCenter(docCenter);
				uploadCount++;
			}
		}

		return uploadCount;
	}

	@Transactional
	public boolean deleteFile(HttpSession session, int basicId, int docId) throws CustomException {
		BasicInfo basicInfo = basicInfoDao.queryById(basicId);
		DocCenter docCenter = docCenterDao.queryById(docId);
		if (basicInfo == null) {
			throw new CustomException("操作:删除文件,用户不存在!");
		}
		if (docCenter == null) {
			throw new CustomException("操作:删除文件,文件不存在!");
		}

		String basePath = session.getServletContext().getRealPath(SpecialValues.DOCS_BASE_PATH);
		basePath += File.separator;
		FileManager.removeFile(basePath + docCenter.getDocAddress());

		docCenterDao.deleteById(docId);

		return true;
	}

	public DocsQueryExecution queryDocs(HttpSession session, int basicId) throws CustomException {
		BasicInfo basicInfo = basicInfoDao.queryById(basicId);
		if (basicInfo == null) {
			throw new CustomException("操作:查询文件,用户不存在!");
		}
		DocCenter[] docCenters = docCenterDao.queryByBasicId(basicId);
		String[] docNames = new String[docCenters.length];
		int[] docIds = new int[docCenters.length];
		Date[] publishDates = new Date[docCenters.length];
		int[] docSizes = new int[docCenters.length];
		for (int i = 0; i < docCenters.length; i++) {
			docNames[i] = docCenters[i].getDocAddress().split("-")[1];
			docIds[i] = docCenters[i].getDocId();
			publishDates[i] = docCenters[i].getPublishDate();

			File file = new File(session.getServletContext().getRealPath(SpecialValues.DOCS_BASE_PATH) + File.separator + docCenters[i].getDocAddress());
			docSizes[i] = (int) file.length();
		}
		return new DocsQueryExecution(docNames, docIds, publishDates, docSizes);
	}

	public String downloadDoc(int basicId, int docId) throws CustomException {
		BasicInfo basicInfo = basicInfoDao.queryById(basicId);
		if (basicInfo == null) {
			throw new CustomException("操作:下载文件,用户不存在!");
		}
		DocCenter docCenter = docCenterDao.queryById(docId);
		if (docCenter == null) {
			throw new CustomException("操作:下载文件,文件不存在!");
		}

		return docCenter.getDocAddress();
	}
}