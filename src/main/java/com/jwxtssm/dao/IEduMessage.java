package com.jwxtssm.dao;

import com.jwxtssm.pojo.mapper.EduMessage;
import org.springframework.stereotype.Repository;

@Repository
public interface IEduMessage {
	int addEduMessage(EduMessage eduMessage);
}
