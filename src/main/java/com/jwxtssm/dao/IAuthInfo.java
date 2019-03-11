package com.jwxtssm.dao;

import com.jwxtssm.pojo.AuthInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthInfo {
	int addAuthInfo(AuthInfo authInfo);
}
