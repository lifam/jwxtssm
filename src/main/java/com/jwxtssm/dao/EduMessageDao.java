package com.jwxtssm.dao;

import com.jwxtssm.entity.EduMessage;
import org.springframework.stereotype.Repository;

@Repository
public interface EduMessageDao {
	int addEduMessage(EduMessage eduMessage);
}
