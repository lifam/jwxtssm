package com.jwxtssm.dao;

import com.jwxtssm.entity.DocCenter;
import org.springframework.stereotype.Repository;

@Repository
public interface DocCenterDao {
	int addDocCenter(DocCenter docCenter);
	DocCenter queryById(int docId);
	DocCenter[] queryByBasicId(int basicId);
	int updateById(DocCenter docCenter);
	int deleteById(int docId);
}
