package com.jwxtssm.dao;

import com.jwxtssm.pojo.mapper.Org;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrg {
	int addOrg(Org org);
}
