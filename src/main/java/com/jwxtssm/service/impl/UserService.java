package com.jwxtssm.service.impl;

import com.jwxtssm.common.Utils;
import com.jwxtssm.dao.BasicInfoDao;
import com.jwxtssm.dto.Result;
import com.jwxtssm.dto.UserLoginExecution;
import com.jwxtssm.entity.BasicInfo;
import com.jwxtssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class UserService implements IUserService {
	@Autowired
	BasicInfoDao basicInfoDao;

	@Override
	public Result<UserLoginExecution> login(String userId, String password) {
		int viceId = Integer.valueOf(userId);
		BasicInfo basicInfo = basicInfoDao.queryByViceId(viceId);
		if (basicInfo == null) return new Result<>(false, "用户id(学号/职工号)不存在!");
		else {
			try {
				if (!basicInfo.getPassword().equals(Utils.generateSHA256Digest(password)))
					return new Result<>(false, "用户密码不正确!");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return new Result<>(true, new UserLoginExecution(basicInfo.getBasicId()));
		}
	}
}
