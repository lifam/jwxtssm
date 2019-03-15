package com.jwxtssm.service.impl;

import com.jwxtssm.dao.MajorDao;
import com.jwxtssm.dto.MajorQueryExecution;
import com.jwxtssm.entity.Major;
import com.jwxtssm.service.IMajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MajorService implements IMajorService {
	@Autowired
	MajorDao majorDao;

	@Override
	public MajorQueryExecution queryAll() {
		Major[] majors = majorDao.queryAll();
		String[] majorNames = new String[majors.length];
		int[] majorIds = new int[majors.length];
		for (int i = 0; i < majors.length; i++) {
			majorNames[i] = majors[i].getName();
			majorIds[i] = majors[i].getMajorId();
		}
		return new MajorQueryExecution(majorNames, majorIds);
	}
}
