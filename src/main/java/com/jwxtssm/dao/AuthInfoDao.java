package com.jwxtssm.dao;

import com.jwxtssm.entity.AuthInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthInfoDao {
	int addAuthInfo(AuthInfo authInfo);
	AuthInfo queryById(int authId);

}
