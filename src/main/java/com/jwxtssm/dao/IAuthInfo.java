package com.jwxtssm.dao;

import com.jwxtssm.pojo.mapper.AuthInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthInfo {
	int addAuthInfo(AuthInfo authInfo);
}
