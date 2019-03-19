package com.jwxtssm.service;

import com.jwxtssm.dto.Result;
import com.jwxtssm.dto.UserInfoExecution;
import com.jwxtssm.dto.UserLoginExecution;
import com.jwxtssm.exception.CustomException;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

public interface IUserService {
	Result<UserLoginExecution> login(String userId, String password);

	UserInfoExecution getUserInfo(int basicId) throws CustomException;

	void updateBasicInfo(int basicId, String name, String password, String sex, String height, String weight, String
			birth, String address, String formalId, String infoTransparency) throws CustomException,
			UnsupportedEncodingException;

	void updateAddressInfo(int basicId, String addressInfoes) throws CustomException;
}
