package com.jwxtssm.dao;

import com.jwxtssm.entity.SystemMessage;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemMessageDao {
	int addSystemMessage(SystemMessage systemMessage);
}
