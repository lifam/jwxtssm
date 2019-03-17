package com.jwxtssm.service.impl;

import com.jwxtssm.common.DefaultValues;
import com.jwxtssm.common.SpecialValues;
import com.jwxtssm.dao.BasicInfoDao;
import com.jwxtssm.dao.DocCenterDao;
import com.jwxtssm.entity.BasicInfo;
import com.jwxtssm.entity.DocCenter;
import com.jwxtssm.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class DefaultService {
	@Autowired
	BasicInfoDao basicInfoDao;
	@Autowired
	DocCenterDao docCenterDao;

	public String getHeadImgByBasicId(int basicId) {
		BasicInfo basicInfo = basicInfoDao.queryById(basicId);
		if (basicInfo == null || basicInfo.getHeadImg() == DefaultValues.HEAD_IMG) return "images/defaultHeadImg.jpg";
		DocCenter docCenter = docCenterDao.queryById(basicInfo.getHeadImg());
		return SpecialValues.HEAD_IMG_BASE_PATH + File.separator + docCenter.getDocAddress();
	}
}
