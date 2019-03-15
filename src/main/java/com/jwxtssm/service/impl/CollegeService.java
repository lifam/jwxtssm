package com.jwxtssm.service.impl;

import com.jwxtssm.dao.CollegeDao;
import com.jwxtssm.dto.CollegeQueryExecution;
import com.jwxtssm.dto.Result;
import com.jwxtssm.entity.College;
import com.jwxtssm.service.ICollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeService implements ICollegeService {
	@Autowired
	CollegeDao collegeDao;

	@Override
	public CollegeQueryExecution queryAll() {
		College[] colleges = collegeDao.queryAll();
		String[] collegeNames = new String[colleges.length];
		int[] collegeIds = new int[colleges.length];
		for (int i = 0; i < colleges.length; i++) {
			collegeNames[i] = colleges[i].getName();
			collegeIds[i] = colleges[i].getCollegeId();
		}
		return new CollegeQueryExecution(collegeNames, collegeIds);
	}
}
