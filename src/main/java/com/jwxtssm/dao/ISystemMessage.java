package com.jwxtssm.dao;

import com.jwxtssm.pojo.mapper.SystemMessage;
import org.springframework.stereotype.Repository;

@Repository
public interface ISystemMessage {
	int addSystemMessage(SystemMessage systemMessage);
}
