package com.jwxtssm.dao;

import com.jwxtssm.BaseTest;
import com.jwxtssm.entity.BasicInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class testBasicInfoDao extends BaseTest {
	@Autowired
	BasicInfoDao basicInfoDao;

	@Test
	public void testQueryByViceId() {
		BasicInfo basicInfo = basicInfoDao.queryByViceId(15003500);
		System.out.println(basicInfo);
	}
}
