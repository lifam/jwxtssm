package com.jwxtssm.dao;

import com.jwxtssm.pojo.mapper.AttachDoc;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttachDoc {
	int addAttachDoc(AttachDoc attachDoc);
}
