package com.jwxtssm.dao;

import com.jwxtssm.pojo.mapper.BasicInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface IBasicInfo {
	int addBasicInfo(BasicInfo basicInfo);
}
