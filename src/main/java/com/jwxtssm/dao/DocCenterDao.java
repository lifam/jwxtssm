package com.jwxtssm.dao;

import com.jwxtssm.entity.DocCenter;
import org.springframework.stereotype.Repository;

@Repository
public interface DocCenterDao {
	int addDocCenter(DocCenter docCenter);
}
