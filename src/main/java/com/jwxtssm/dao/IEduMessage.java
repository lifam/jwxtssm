package com.jwxtssm.dao;

import com.jwxtssm.pojo.EduMessage;
import org.springframework.stereotype.Repository;

@Repository
public interface IEduMessage {
	int addEduMessage(EduMessage eduMessage);
}
