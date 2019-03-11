package com.jwxtssm.dao;

import com.jwxtssm.pojo.BasicInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface IBasicInfo {
	int addBasicInfo(BasicInfo basicInfo);
}
