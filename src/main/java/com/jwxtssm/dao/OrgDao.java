package com.jwxtssm.dao;

import com.jwxtssm.entity.Org;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgDao {
	int addOrg(Org org);
	Org queryById(int orgId);
	Org[] queryByName(String name);
	Org[] queryAll();
}
