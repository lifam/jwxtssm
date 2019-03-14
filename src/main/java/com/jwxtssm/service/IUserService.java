package com.jwxtssm.service;

import com.jwxtssm.dto.Result;
import com.jwxtssm.dto.UserLoginExecution;

public interface IUserService {
	Result<UserLoginExecution> login(String userId, String password);
}
