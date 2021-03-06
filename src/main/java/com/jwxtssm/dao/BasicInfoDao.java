package com.jwxtssm.dao;

import com.jwxtssm.entity.BasicInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicInfoDao {
	int addBasicInfo(BasicInfo basicInfo);
	BasicInfo queryByViceId(int viceId);
	BasicInfo queryById(int basicId);
	int updateHeadImg(BasicInfo basicInfo);
	int updateAll(BasicInfo basicInfo);
}
