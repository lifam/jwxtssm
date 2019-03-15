package com.jwxtssm.service.impl;

import com.jwxtssm.dao.OrgDao;
import com.jwxtssm.dto.OrgQueryExecution;
import com.jwxtssm.entity.Org;
import com.jwxtssm.service.IOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgService implements IOrgService {
	@Autowired
	OrgDao orgDao;
	@Override
	public OrgQueryExecution queryAll() {
		Org[] orgs = orgDao.queryAll();
		String[] orgNames = new String[orgs.length];
		int[] orgIds = new int[orgs.length];
		for (int i = 0; i < orgs.length; i++) {
			orgNames[i] = orgs[i].getName();
			orgIds[i] = orgs[i].getOrgId();
		}
		return new OrgQueryExecution(orgNames, orgIds);
	}
}
