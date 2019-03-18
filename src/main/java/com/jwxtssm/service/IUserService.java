package com.jwxtssm.service;

import com.jwxtssm.dto.Result;
import com.jwxtssm.dto.UserInfoExecution;
import com.jwxtssm.dto.UserLoginExecution;
import com.jwxtssm.exception.CustomException;

import javax.servlet.http.HttpSession;

public interface IUserService {
	Result<UserLoginExecution> login(String userId, String password);
	UserInfoExecution getUserInfo(int basicId) throws CustomException;
}
