package com.jwxtssm.dao;

import com.jwxtssm.pojo.SystemMessage;
import org.springframework.stereotype.Repository;

@Repository
public interface ISystemMessage {
	int addSystemMessage(SystemMessage systemMessage);
}
