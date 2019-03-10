package com.jwxtssm.dao;

import com.jwxtssm.pojo.mapper.DocCenter;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocCenter {
	int addDocCenter(DocCenter docCenter);
}
